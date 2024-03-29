/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl.impl;

import com.minres.rdl.rdl.PropertyComponent;
import com.minres.rdl.rdl.PropertyUsage;
import com.minres.rdl.rdl.RdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.impl.PropertyUsageImpl#getComponents <em>Components</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyUsageImpl extends MinimalEObjectImpl.Container implements PropertyUsage
{
  /**
   * The cached value of the '{@link #getComponents() <em>Components</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponents()
   * @generated
   * @ordered
   */
  protected EList<PropertyComponent> components;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyUsageImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RdlPackage.Literals.PROPERTY_USAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PropertyComponent> getComponents()
  {
    if (components == null)
    {
      components = new EDataTypeEList<PropertyComponent>(PropertyComponent.class, this, RdlPackage.PROPERTY_USAGE__COMPONENTS);
    }
    return components;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RdlPackage.PROPERTY_USAGE__COMPONENTS:
        return getComponents();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RdlPackage.PROPERTY_USAGE__COMPONENTS:
        getComponents().clear();
        getComponents().addAll((Collection<? extends PropertyComponent>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RdlPackage.PROPERTY_USAGE__COMPONENTS:
        getComponents().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RdlPackage.PROPERTY_USAGE__COMPONENTS:
        return components != null && !components.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (components: ");
    result.append(components);
    result.append(')');
    return result.toString();
  }

} //PropertyUsageImpl
