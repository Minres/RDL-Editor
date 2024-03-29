/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.Instantiation#getInstanceType <em>Instance Type</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.Instantiation#getAlias <em>Alias</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.Instantiation#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.Instantiation#getComponent <em>Component</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.Instantiation#getComponentInstances <em>Component Instances</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getInstantiation()
 * @model
 * @generated
 */
public interface Instantiation extends EObject
{
  /**
   * Returns the value of the '<em><b>Instance Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance Type</em>' containment reference.
   * @see #setInstanceType(EnumInstanceType)
   * @see com.minres.rdl.rdl.RdlPackage#getInstantiation_InstanceType()
   * @model containment="true"
   * @generated
   */
  EnumInstanceType getInstanceType();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.Instantiation#getInstanceType <em>Instance Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance Type</em>' containment reference.
   * @see #getInstanceType()
   * @generated
   */
  void setInstanceType(EnumInstanceType value);

  /**
   * Returns the value of the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' attribute.
   * @see #setAlias(String)
   * @see com.minres.rdl.rdl.RdlPackage#getInstantiation_Alias()
   * @model
   * @generated
   */
  String getAlias();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.Instantiation#getAlias <em>Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' attribute.
   * @see #getAlias()
   * @generated
   */
  void setAlias(String value);

  /**
   * Returns the value of the '<em><b>Component Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Ref</em>' reference.
   * @see #setComponentRef(ComponentDefinition)
   * @see com.minres.rdl.rdl.RdlPackage#getInstantiation_ComponentRef()
   * @model
   * @generated
   */
  ComponentDefinition getComponentRef();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.Instantiation#getComponentRef <em>Component Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component Ref</em>' reference.
   * @see #getComponentRef()
   * @generated
   */
  void setComponentRef(ComponentDefinition value);

  /**
   * Returns the value of the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component</em>' containment reference.
   * @see #setComponent(ComponentDefinition)
   * @see com.minres.rdl.rdl.RdlPackage#getInstantiation_Component()
   * @model containment="true"
   * @generated
   */
  ComponentDefinition getComponent();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.Instantiation#getComponent <em>Component</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component</em>' containment reference.
   * @see #getComponent()
   * @generated
   */
  void setComponent(ComponentDefinition value);

  /**
   * Returns the value of the '<em><b>Component Instances</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.rdl.rdl.ComponentInstance}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Instances</em>' containment reference list.
   * @see com.minres.rdl.rdl.RdlPackage#getInstantiation_ComponentInstances()
   * @model containment="true"
   * @generated
   */
  EList<ComponentInstance> getComponentInstances();

} // Instantiation
