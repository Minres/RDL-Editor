package com.minres.rdl;

import com.google.common.base.Objects;
import com.minres.rdl.IntegerWithRadix;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.EnumDefinition;
import com.minres.rdl.rdl.ExplicitPropertyAssignment;
import com.minres.rdl.rdl.InstancePropertyRef;
import com.minres.rdl.rdl.Instantiation;
import com.minres.rdl.rdl.PropertyAssignment;
import com.minres.rdl.rdl.PropertyAssignmentRhs;
import com.minres.rdl.rdl.PropertyEnum;
import com.minres.rdl.rdl.RValue;
import com.minres.rdl.rdl.RValueConstant;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RdlUtil {
  public static IntegerWithRadix addressValue(final ComponentInstance instance) {
    Object _address = instance.getAddress();
    boolean _tripleNotEquals = (_address != null);
    if (_tripleNotEquals) {
      Object _address_1 = instance.getAddress();
      return ((IntegerWithRadix) _address_1);
    } else {
      return new IntegerWithRadix(Integer.valueOf(0));
    }
  }
  
  public long accessWidth(final ComponentDefinition definition) {
    long size = 32L;
    final Function1<PropertyAssignment, Boolean> _function = (PropertyAssignment pa) -> {
      return Boolean.valueOf(((pa instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa).getName(), PropertyEnum.ACCESSWIDTH)));
    };
    final PropertyAssignment pa = IterableExtensions.<PropertyAssignment>findFirst(definition.getPropertyAssignments(), _function);
    if ((pa != null)) {
      String _effectiveValue = RdlUtil.effectiveValue(((ExplicitPropertyAssignment) pa).getRhs());
      final IntegerWithRadix sz = new IntegerWithRadix(_effectiveValue);
      size = sz.value;
    }
    return size;
  }
  
  public static long regWidth(final ComponentDefinition definition) {
    long size = 32L;
    final Function1<PropertyAssignment, Boolean> _function = (PropertyAssignment pa) -> {
      return Boolean.valueOf(((pa instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa).getName(), PropertyEnum.REGWIDTH)));
    };
    final PropertyAssignment pa = IterableExtensions.<PropertyAssignment>findFirst(definition.getPropertyAssignments(), _function);
    if ((pa != null)) {
      String _effectiveValue = RdlUtil.effectiveValue(((ExplicitPropertyAssignment) pa).getRhs());
      final IntegerWithRadix sz = new IntegerWithRadix(_effectiveValue);
      size = sz.value;
    }
    return size;
  }
  
  public static long getSize(final Instantiation instantiation) {
    final ComponentDefinition componentDef = RdlUtil.definingComponent(instantiation);
    ComponentDefinitionType _type = componentDef.getType();
    if (_type != null) {
      switch (_type) {
        case REG:
          final Function1<PropertyAssignment, Boolean> _function = (PropertyAssignment pa) -> {
            return Boolean.valueOf(((pa instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa).getName(), PropertyEnum.REGWIDTH)));
          };
          final PropertyAssignment pa = IterableExtensions.<PropertyAssignment>findFirst(componentDef.getPropertyAssignments(), _function);
          if ((pa != null)) {
            String _effectiveValue = RdlUtil.effectiveValue(((ExplicitPropertyAssignment) pa).getRhs());
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
            String _effectiveValue_1 = RdlUtil.effectiveValue(((ExplicitPropertyAssignment) pa_1).getRhs());
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
  
  public static String effectiveName(final ComponentDefinition definition) {
    String _name = definition.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      return definition.getName().replaceAll("\\s+", "_");
    } else {
      final Function1<PropertyAssignment, Boolean> _function = (PropertyAssignment pa) -> {
        return Boolean.valueOf(((pa instanceof ExplicitPropertyAssignment) && Objects.equal(((ExplicitPropertyAssignment) pa).getName(), PropertyEnum.NAME)));
      };
      final PropertyAssignment pa = IterableExtensions.<PropertyAssignment>findFirst(definition.getPropertyAssignments(), _function);
      if ((pa != null)) {
        return RdlUtil.effectiveValue(((ExplicitPropertyAssignment) pa).getRhs()).replaceAll("\\s+", "_");
      } else {
        ComponentDefinitionType _type = definition.getType();
        return ("unnamed_" + _type).replaceAll("\\s+", "_");
      }
    }
  }
  
  public static String effectiveValue(final PropertyAssignmentRhs rhs) {
    String _xifexpression = null;
    RValue _value = rhs.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      _xifexpression = RdlUtil.effectiveValue(rhs.getValue());
    } else {
      String _xifexpression_1 = null;
      InstancePropertyRef _instPropRef = rhs.getInstPropRef();
      boolean _tripleNotEquals_1 = (_instPropRef != null);
      if (_tripleNotEquals_1) {
        _xifexpression_1 = RdlUtil.effectiveValue(rhs.getInstPropRef());
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
  
  public static String effectiveValue(final RValue rvalue) {
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
  
  public static String effectiveValue(final InstancePropertyRef ref) {
    throw new RuntimeException();
  }
  
  public static ComponentDefinition definingComponent(final Instantiation instantiation) {
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
  
  public static int instanceCount(final ComponentDefinition definition, final ComponentDefinitionType type) {
    final Function1<Instantiation, Integer> _function = (Instantiation it) -> {
      return Integer.valueOf(it.getComponentInstances().size());
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer p1, Integer p2) -> {
      return Integer.valueOf(((p1).intValue() + (p2).intValue()));
    };
    return (int) IterableExtensions.<Integer>reduce(IterableExtensions.<Instantiation, Integer>map(RdlUtil.instantiationsOfType(definition, type), _function), _function_1);
  }
  
  public static Iterable<Instantiation> instantiationsOfType(final ComponentDefinition definition, final ComponentDefinitionType type) {
    final Function1<Instantiation, Boolean> _function = (Instantiation it) -> {
      ComponentDefinitionType _type = RdlUtil.definingComponent(it).getType();
      return Boolean.valueOf(Objects.equal(_type, type));
    };
    return IterableExtensions.<Instantiation>filter(definition.getInstantiations(), _function);
  }
  
  public static long byteSize(final Instantiation instantiation, final long start) {
    final ComponentDefinition componentDefinition = RdlUtil.definingComponent(instantiation);
    long componentSize = 0;
    ComponentDefinitionType _type = RdlUtil.definingComponent(instantiation).getType();
    boolean _equals = Objects.equal(_type, ComponentDefinitionType.REG);
    if (_equals) {
      long _regWidth = RdlUtil.regWidth(RdlUtil.definingComponent(instantiation));
      long _divide = (_regWidth / 8);
      componentSize = _divide;
    } else {
      EList<Instantiation> _instantiations = componentDefinition.getInstantiations();
      for (final Instantiation subInstantiation : _instantiations) {
        componentSize = RdlUtil.byteSize(subInstantiation, componentSize);
      }
    }
    long lastTopAddress = start;
    long topAddress = start;
    EList<ComponentInstance> _componentInstances = instantiation.getComponentInstances();
    for (final ComponentInstance componentInstance : _componentInstances) {
      {
        long _xifexpression = (long) 0;
        Object _address = componentInstance.getAddress();
        boolean _tripleNotEquals = (_address != null);
        if (_tripleNotEquals) {
          Object _address_1 = componentInstance.getAddress();
          _xifexpression = (((IntegerWithRadix) _address_1).value + componentSize);
        } else {
          _xifexpression = (componentSize + lastTopAddress);
        }
        final long byteSize = _xifexpression;
        topAddress = Math.max(topAddress, byteSize);
        lastTopAddress = byteSize;
      }
    }
    return topAddress;
  }
  
  public static long byteSize(final Instantiation instantiation) {
    final ComponentDefinition componentDefinition = RdlUtil.definingComponent(instantiation);
    long componentSize = 0;
    ComponentDefinitionType _type = RdlUtil.definingComponent(instantiation).getType();
    boolean _equals = Objects.equal(_type, ComponentDefinitionType.REG);
    if (_equals) {
      long _regWidth = RdlUtil.regWidth(RdlUtil.definingComponent(instantiation));
      long _divide = (_regWidth / 8);
      componentSize = _divide;
    } else {
      EList<Instantiation> _instantiations = componentDefinition.getInstantiations();
      for (final Instantiation subInstantiation : _instantiations) {
        componentSize = RdlUtil.byteSize(subInstantiation, componentSize);
      }
    }
    return componentSize;
  }
}
