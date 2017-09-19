package com.minres.rdl.generator;

import com.google.common.base.Objects;
import com.minres.rdl.IntegerWithRadix;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.EnumDefinition;
import com.minres.rdl.rdl.ExplicitPropertyAssignment;
import com.minres.rdl.rdl.InstancePropertyRef;
import com.minres.rdl.rdl.Instantiation;
import com.minres.rdl.rdl.PropertyAssignment;
import com.minres.rdl.rdl.PropertyAssignmentRhs;
import com.minres.rdl.rdl.PropertyEnum;
import com.minres.rdl.rdl.RValue;
import com.minres.rdl.rdl.RValueConstant;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class RdlBaseGenerator {
  public long accessWidth(final ComponentDefinition definition) {
    long size = 32L;
    final Function1<PropertyAssignment, Boolean> _function = (PropertyAssignment pa) -> {
      return Boolean.valueOf(((pa instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa).getName(), PropertyEnum.ACCESSWIDTH)));
    };
    final PropertyAssignment pa = IterableExtensions.<PropertyAssignment>findFirst(definition.getPropertyAssignments(), _function);
    if ((pa != null)) {
      String _effectiveValue = this.effectiveValue(((ExplicitPropertyAssignment) pa).getRhs());
      final IntegerWithRadix sz = new IntegerWithRadix(_effectiveValue);
      size = sz.value;
    }
    return size;
  }
  
  public long getSize(final Instantiation instantiation) {
    final ComponentDefinition componentDef = this.definingComponent(instantiation);
    ComponentDefinitionType _type = componentDef.getType();
    if (_type != null) {
      switch (_type) {
        case REG:
          final Function1<PropertyAssignment, Boolean> _function = (PropertyAssignment pa) -> {
            return Boolean.valueOf(((pa instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa).getName(), PropertyEnum.REGWIDTH)));
          };
          final PropertyAssignment pa = IterableExtensions.<PropertyAssignment>findFirst(componentDef.getPropertyAssignments(), _function);
          if ((pa != null)) {
            String _effectiveValue = this.effectiveValue(((ExplicitPropertyAssignment) pa).getRhs());
            final IntegerWithRadix sz = new IntegerWithRadix(_effectiveValue);
            return sz.value;
          }
          return 32L;
        case FIELD:
          final Function1<PropertyAssignment, Boolean> _function_1 = (PropertyAssignment pa_1) -> {
            return Boolean.valueOf(((pa_1 instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa_1).getName(), PropertyEnum.FIELDWIDTH)));
          };
          final PropertyAssignment pa_1 = IterableExtensions.<PropertyAssignment>findFirst(componentDef.getPropertyAssignments(), _function_1);
          if ((pa_1 != null)) {
            String _effectiveValue_1 = this.effectiveValue(((ExplicitPropertyAssignment) pa_1).getRhs());
            final IntegerWithRadix sz_1 = new IntegerWithRadix(_effectiveValue_1);
            return sz_1.value;
          }
          return 1L;
        default:
          return 0L;
      }
    } else {
      return 0L;
    }
  }
  
  public String effectiveName(final ComponentDefinition definition) {
    String _xifexpression = null;
    String _name = definition.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      _xifexpression = definition.getName();
    } else {
      String _xblockexpression = null;
      {
        final Function1<PropertyAssignment, Boolean> _function = (PropertyAssignment pa) -> {
          return Boolean.valueOf(((pa instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa).getName(), PropertyEnum.NAME)));
        };
        final PropertyAssignment pa = IterableExtensions.<PropertyAssignment>findFirst(definition.getPropertyAssignments(), _function);
        _xblockexpression = this.effectiveValue(((ExplicitPropertyAssignment) pa).getRhs());
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public String effectiveValue(final PropertyAssignmentRhs rhs) {
    String _xifexpression = null;
    RValue _value = rhs.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      _xifexpression = this.effectiveValue(rhs.getValue());
    } else {
      String _xifexpression_1 = null;
      InstancePropertyRef _instPropRef = rhs.getInstPropRef();
      boolean _tripleNotEquals_1 = (_instPropRef != null);
      if (_tripleNotEquals_1) {
        _xifexpression_1 = this.effectiveValue(rhs.getInstPropRef());
      } else {
        String _xifexpression_2 = null;
        EnumDefinition _enumRef = rhs.getEnumRef();
        boolean _tripleNotEquals_2 = (_enumRef != null);
        if (_tripleNotEquals_2) {
          _xifexpression_2 = rhs.getEnumRef().getName();
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String effectiveValue(final RValue rvalue) {
    String _xifexpression = null;
    String _str = rvalue.getStr();
    boolean _tripleNotEquals = (_str != null);
    if (_tripleNotEquals) {
      _xifexpression = rvalue.getStr();
    } else {
      String _xifexpression_1 = null;
      RValueConstant _val = rvalue.getVal();
      boolean _notEquals = (!Objects.equal(_val, RValueConstant.UNDEFINED));
      if (_notEquals) {
        _xifexpression_1 = rvalue.getVal().getLiteral();
      } else {
        String _xifexpression_2 = null;
        Object _num = rvalue.getNum();
        boolean _tripleNotEquals_1 = (_num != null);
        if (_tripleNotEquals_1) {
          String _xblockexpression = null;
          {
            Object _num_1 = rvalue.getNum();
            final IntegerWithRadix num = ((IntegerWithRadix) _num_1);
            _xblockexpression = num.toString();
          }
          _xifexpression_2 = _xblockexpression;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String effectiveValue(final InstancePropertyRef ref) {
    return null;
  }
  
  public ComponentDefinition definingComponent(final Instantiation instantiation) {
    ComponentDefinition _xifexpression = null;
    ComponentDefinition _componentRef = instantiation.getComponentRef();
    boolean _tripleNotEquals = (_componentRef != null);
    if (_tripleNotEquals) {
      _xifexpression = instantiation.getComponentRef();
    } else {
      _xifexpression = instantiation.getComponent();
    }
    return _xifexpression;
  }
  
  public abstract String generateHeader();
  
  public abstract String generateSource();
}
