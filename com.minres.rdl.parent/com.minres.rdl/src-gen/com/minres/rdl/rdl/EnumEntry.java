/**
 * generated by Xtext 2.13.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.EnumEntry#getName <em>Name</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.EnumEntry#getIndex <em>Index</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.EnumEntry#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getEnumEntry()
 * @model
 * @generated
 */
public interface EnumEntry extends EObject
{
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
   * @see com.minres.rdl.rdl.RdlPackage#getEnumEntry_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.EnumEntry#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' attribute.
   * @see #setIndex(Object)
   * @see com.minres.rdl.rdl.RdlPackage#getEnumEntry_Index()
   * @model
   * @generated
   */
  Object getIndex();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.EnumEntry#getIndex <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' attribute.
   * @see #getIndex()
   * @generated
   */
  void setIndex(Object value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link com.minres.rdl.rdl.EnumProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see com.minres.rdl.rdl.RdlPackage#getEnumEntry_Properties()
   * @model containment="true"
   * @generated
   */
  EList<EnumProperty> getProperties();

} // EnumEntry
