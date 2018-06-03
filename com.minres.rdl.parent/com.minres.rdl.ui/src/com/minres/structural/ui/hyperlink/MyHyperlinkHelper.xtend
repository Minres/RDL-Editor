package com.minres.structural.ui.hyperlink

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jface.text.Region
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.impl.ImportUriResolver
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor
import org.eclipse.xtext.util.TextRegion

class MyHyperlinkHelper extends HyperlinkHelper {
	
	@Inject	ImportUriResolver resolver;

	override createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		val region = new TextRegion(offset, 0)
		val crossRefNode = getEObjectAtOffsetHelper().getCrossReferenceNode(resource, region);
		if (crossRefNode === null){
			val parseResult = resource.getParseResult();
			if (parseResult !== null) {
				val leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset());
				//val rule = EcoreUtil2.getContainerOfType(leaf.grammarElement, AbstractRule);
				val semObj = NodeModelUtils.findActualSemanticObjectFor(leaf);
				val importURI = resolver.resolve(semObj);
				if (importURI !== null && EcoreUtil2.isValidUri(semObj, URI.createURI(importURI))) {
					val referencedResource = EcoreUtil2.getResource(resource, importURI)
					if(referencedResource !== null && referencedResource.contents.size>0){
						val top = referencedResource.contents.get(0)
						val textRegion = leaf.getTextRegion();
						val uri = EcoreUtil.getURI(top);
						val result = hyperlinkProvider.get();
						result.setHyperlinkRegion(new Region(textRegion.getOffset(), textRegion.getLength()));
						result.setURI(if(uri.isPlatformResource()) uri else resource.getResourceSet().getURIConverter().normalize(uri));
						result.setHyperlinkText(labelProvider.getText(top));
						if(result instanceof MyXtextHyperlink) result.selectTarget=false
						acceptor.accept(result);
					}
				}
			}
		} else {
			val crossLinkedEObject = getEObjectAtOffsetHelper().getCrossReferencedElement(crossRefNode);
			if (crossLinkedEObject !== null && !crossLinkedEObject.eIsProxy()) {
				createHyperlinksTo(resource, crossRefNode, crossLinkedEObject, acceptor);
			}
		}
	}
		
}