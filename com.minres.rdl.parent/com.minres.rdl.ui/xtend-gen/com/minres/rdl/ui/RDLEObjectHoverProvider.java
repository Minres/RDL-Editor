package com.minres.rdl.ui;

import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.Instantiation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
        if ((parent instanceof Instantiation)) {
          ComponentDefinitionType _xifexpression = null;
          ComponentDefinition _componentRef = ((Instantiation)parent).getComponentRef();
          boolean _tripleNotEquals = (_componentRef != null);
          if (_tripleNotEquals) {
            _xifexpression = ((Instantiation)parent).getComponentRef().getType();
          } else {
            _xifexpression = ((Instantiation)parent).getComponent().getType();
          }
          String _firstUpper = StringExtensions.toFirstUpper(_xifexpression.getLiteral());
          String _plus = (_firstUpper + " ");
          String _name = ((ComponentInstance)o).getName();
          return (_plus + _name);
        }
      }
    }
    return super.getFirstLine(o);
  }
}
