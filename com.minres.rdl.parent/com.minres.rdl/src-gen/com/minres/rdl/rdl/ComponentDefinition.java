/**
 * generated by Xtext 2.13.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.ComponentDefinition#getType <em>Type</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.ComponentDefinition#getName <em>Name</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.ComponentDefinition#getComponentDefinitions <em>Component Definitions</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.ComponentDefinition#getInstantiations <em>Instantiations</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.ComponentDefinition#getPropertyAssignments <em>Property Assignments</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.ComponentDefinition#getEnumDefinitions <em>Enum Definitions</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getComponentDefinition()
 * @model
 * @generated
 */
public interface ComponentDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.minres.rdl.rdl.ComponentDefinitionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.minres.rdl.rdl.ComponentDefinitionType
   * @see #setType(ComponentDefinitionType)
   * @see com.minres.rdl.rdl.RdlPackage#getComponentDefinition_Type()
   * @model
   * @generated
   */
  ComponentDefinitionType getType();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.ComponentDefinition#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see com.minres.rdl.rdl.ComponentDefinitionType
   * @see #getType()
   * @generated
   */
  void setType(ComponentDefinitionType value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.minres.rdl.rdl.RdlPackage#getComponentDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.ComponentDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Component Definitions</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.rdl.rdl.ComponentDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Definitions</em>' containment reference list.
   * @see com.minres.rdl.rdl.RdlPackage#getComponentDefinition_ComponentDefinitions()
   * @model containment="true"
   * @generated
   */
  EList<ComponentDefinition> getComponentDefinitions();

  /**
   * Returns the value of the '<em><b>Instantiations</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.rdl.rdl.Instantiation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instantiations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instantiations</em>' containment reference list.
   * @see com.minres.rdl.rdl.RdlPackage#getComponentDefinition_Instantiations()
   * @model containment="true"
   * @generated
   */
  EList<Instantiation> getInstantiations();

  /**
   * Returns the value of the '<em><b>Property Assignments</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.rdl.rdl.PropertyAssignment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Assignments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Assignments</em>' containment reference list.
   * @see com.minres.rdl.rdl.RdlPackage#getComponentDefinition_PropertyAssignments()
   * @model containment="true"
   * @generated
   */
  EList<PropertyAssignment> getPropertyAssignments();

  /**
   * Returns the value of the '<em><b>Enum Definitions</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.rdl.rdl.EnumDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Definitions</em>' containment reference list.
   * @see com.minres.rdl.rdl.RdlPackage#getComponentDefinition_EnumDefinitions()
   * @model containment="true"
   * @generated
   */
  EList<EnumDefinition> getEnumDefinitions();

} // ComponentDefinition
