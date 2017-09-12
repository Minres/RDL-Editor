package com.minres.rdl.ui;

import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.ImmediateInstantiation;
import com.minres.rdl.rdl.NamedInstantiation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

@SuppressWarnings("all")
public class RDLEObjectHoverProvider extends DefaultEObjectHoverProvider {
  @Override
  protected String getFirstLine(final EObject o) {
    boolean _matched = false;
    if (o instanceof ComponentDefinition) {
      _matched=true;
      String _name = ((ComponentDefinition)o).getName();
      String _plus = ("Component " + _name);
      String _plus_1 = (_plus + " of type ");
      String _literal = ((ComponentDefinition)o).getType().getLiteral();
      return (_plus_1 + _literal);
    }
    if (!_matched) {
      if (o instanceof ComponentInstance) {
        _matched=true;
        final EObject parent = ((ComponentInstance)o).eContainer();
        if ((parent instanceof ImmediateInstantiation)) {
          EObject _eContainer = ((ImmediateInstantiation)parent).eContainer();
          final ComponentDefinition compDef = ((ComponentDefinition) _eContainer);
          String _literal = compDef.getType().getLiteral();
          String _plus = (_literal + " ");
          String _name = ((ComponentInstance)o).getName();
          return (_plus + _name);
        } else {
          if ((parent instanceof NamedInstantiation)) {
            String _literal_1 = ((NamedInstantiation)parent).getComponent().getType().getLiteral();
            String _plus_1 = (_literal_1 + " ");
            String _name_1 = ((ComponentInstance)o).getName();
            return (_plus_1 + _name_1);
          }
        }
      }
    }
    return super.getFirstLine(o);
  }
}
