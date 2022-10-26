/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl.util;

import com.minres.rdl.rdl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.minres.rdl.rdl.RdlPackage
 * @generated
 */
public class RdlSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RdlPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdlSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = RdlPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case RdlPackage.ROOT:
      {
        Root root = (Root)theEObject;
        T result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.INCLUDE:
      {
        Include include = (Include)theEObject;
        T result = caseInclude(include);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.PROPERTY_DEFINITION:
      {
        PropertyDefinition propertyDefinition = (PropertyDefinition)theEObject;
        T result = casePropertyDefinition(propertyDefinition);
        if (result == null) result = caseEntity(propertyDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.PROPERTY_DEFAULT:
      {
        PropertyDefault propertyDefault = (PropertyDefault)theEObject;
        T result = casePropertyDefault(propertyDefault);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.PROPERTY_USAGE:
      {
        PropertyUsage propertyUsage = (PropertyUsage)theEObject;
        T result = casePropertyUsage(propertyUsage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.COMPONENT_DEFINITION:
      {
        ComponentDefinition componentDefinition = (ComponentDefinition)theEObject;
        T result = caseComponentDefinition(componentDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.INSTANTIATION:
      {
        Instantiation instantiation = (Instantiation)theEObject;
        T result = caseInstantiation(instantiation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.COMPONENT_INSTANCE:
      {
        ComponentInstance componentInstance = (ComponentInstance)theEObject;
        T result = caseComponentInstance(componentInstance);
        if (result == null) result = caseEntity(componentInstance);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.PROPERTY_ASSIGNMENT:
      {
        PropertyAssignment propertyAssignment = (PropertyAssignment)theEObject;
        T result = casePropertyAssignment(propertyAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.DEFAULT_PROPERY_ASSIGNMENT:
      {
        DefaultProperyAssignment defaultProperyAssignment = (DefaultProperyAssignment)theEObject;
        T result = caseDefaultProperyAssignment(defaultProperyAssignment);
        if (result == null) result = casePropertyAssignment(defaultProperyAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.EXPLICIT_PROPERTY_ASSIGNMENT:
      {
        ExplicitPropertyAssignment explicitPropertyAssignment = (ExplicitPropertyAssignment)theEObject;
        T result = caseExplicitPropertyAssignment(explicitPropertyAssignment);
        if (result == null) result = caseDefaultProperyAssignment(explicitPropertyAssignment);
        if (result == null) result = casePropertyAssignment(explicitPropertyAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.POST_PROPERTY_ASSIGNMENT:
      {
        PostPropertyAssignment postPropertyAssignment = (PostPropertyAssignment)theEObject;
        T result = casePostPropertyAssignment(postPropertyAssignment);
        if (result == null) result = casePropertyAssignment(postPropertyAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.INSTANCE_PROPERTY_REF:
      {
        InstancePropertyRef instancePropertyRef = (InstancePropertyRef)theEObject;
        T result = caseInstancePropertyRef(instancePropertyRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.ENTITY:
      {
        Entity entity = (Entity)theEObject;
        T result = caseEntity(entity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.INSTANCE_REF:
      {
        InstanceRef instanceRef = (InstanceRef)theEObject;
        T result = caseInstanceRef(instanceRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.PROPERTY_ASSIGNMENT_RHS:
      {
        PropertyAssignmentRhs propertyAssignmentRhs = (PropertyAssignmentRhs)theEObject;
        T result = casePropertyAssignmentRhs(propertyAssignmentRhs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.CONCAT:
      {
        Concat concat = (Concat)theEObject;
        T result = caseConcat(concat);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.CONCAT_ELEM:
      {
        ConcatElem concatElem = (ConcatElem)theEObject;
        T result = caseConcatElem(concatElem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.RVALUE:
      {
        RValue rValue = (RValue)theEObject;
        T result = caseRValue(rValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.ENUM_DEFINITION:
      {
        EnumDefinition enumDefinition = (EnumDefinition)theEObject;
        T result = caseEnumDefinition(enumDefinition);
        if (result == null) result = caseEntity(enumDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.ENUM_BODY:
      {
        EnumBody enumBody = (EnumBody)theEObject;
        T result = caseEnumBody(enumBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.ENUM_ENTRY:
      {
        EnumEntry enumEntry = (EnumEntry)theEObject;
        T result = caseEnumEntry(enumEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.ENUM_PROPERTY:
      {
        EnumProperty enumProperty = (EnumProperty)theEObject;
        T result = caseEnumProperty(enumProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RdlPackage.ENUM_INSTANCE_TYPE:
      {
        EnumInstanceType enumInstanceType = (EnumInstanceType)theEObject;
        T result = caseEnumInstanceType(enumInstanceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoot(Root object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInclude(Include object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDefinition(PropertyDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Default</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Default</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDefault(PropertyDefault object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Usage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Usage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyUsage(PropertyUsage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentDefinition(ComponentDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instantiation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instantiation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstantiation(Instantiation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentInstance(ComponentInstance object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRange(Range object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyAssignment(PropertyAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Default Propery Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Default Propery Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefaultProperyAssignment(DefaultProperyAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Explicit Property Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Explicit Property Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExplicitPropertyAssignment(ExplicitPropertyAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Post Property Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Post Property Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostPropertyAssignment(PostPropertyAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Property Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Property Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstancePropertyRef(InstancePropertyRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntity(Entity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceRef(InstanceRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Assignment Rhs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Assignment Rhs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyAssignmentRhs(PropertyAssignmentRhs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concat</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concat</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcat(Concat object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concat Elem</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concat Elem</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcatElem(ConcatElem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RValue</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RValue</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRValue(RValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumDefinition(EnumDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumBody(EnumBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumEntry(EnumEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumProperty(EnumProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Instance Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Instance Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumInstanceType(EnumInstanceType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //RdlSwitch
