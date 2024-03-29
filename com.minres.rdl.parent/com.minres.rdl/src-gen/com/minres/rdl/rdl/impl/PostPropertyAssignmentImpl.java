/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl.impl;

import com.minres.rdl.rdl.InstanceRef;
import com.minres.rdl.rdl.PostPropertyAssignment;
import com.minres.rdl.rdl.PropertyAssignmentRhs;
import com.minres.rdl.rdl.PropertyDefinition;
import com.minres.rdl.rdl.PropertyEnum;
import com.minres.rdl.rdl.RdlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Post Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.impl.PostPropertyAssignmentImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.impl.PostPropertyAssignmentImpl#getPropertyEnum <em>Property Enum</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.impl.PostPropertyAssignmentImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.impl.PostPropertyAssignmentImpl#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PostPropertyAssignmentImpl extends PropertyAssignmentImpl implements PostPropertyAssignment
{
  /**
   * The cached value of the '{@link #getInstance() <em>Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstance()
   * @generated
   * @ordered
   */
  protected InstanceRef instance;

  /**
   * The default value of the '{@link #getPropertyEnum() <em>Property Enum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyEnum()
   * @generated
   * @ordered
   */
  protected static final PropertyEnum PROPERTY_ENUM_EDEFAULT = PropertyEnum.UNSPECIFIED;

  /**
   * The cached value of the '{@link #getPropertyEnum() <em>Property Enum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyEnum()
   * @generated
   * @ordered
   */
  protected PropertyEnum propertyEnum = PROPERTY_ENUM_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected PropertyDefinition property;

  /**
   * The cached value of the '{@link #getRhs() <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRhs()
   * @generated
   * @ordered
   */
  protected PropertyAssignmentRhs rhs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostPropertyAssignmentImpl()
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
    return RdlPackage.Literals.POST_PROPERTY_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InstanceRef getInstance()
  {
    return instance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInstance(InstanceRef newInstance, NotificationChain msgs)
  {
    InstanceRef oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE, oldInstance, newInstance);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInstance(InstanceRef newInstance)
  {
    if (newInstance != instance)
    {
      NotificationChain msgs = null;
      if (instance != null)
        msgs = ((InternalEObject)instance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE, null, msgs);
      if (newInstance != null)
        msgs = ((InternalEObject)newInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE, null, msgs);
      msgs = basicSetInstance(newInstance, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE, newInstance, newInstance));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyEnum getPropertyEnum()
  {
    return propertyEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPropertyEnum(PropertyEnum newPropertyEnum)
  {
    PropertyEnum oldPropertyEnum = propertyEnum;
    propertyEnum = newPropertyEnum == null ? PROPERTY_ENUM_EDEFAULT : newPropertyEnum;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY_ENUM, oldPropertyEnum, propertyEnum));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyDefinition getProperty()
  {
    if (property != null && property.eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject)property;
      property = (PropertyDefinition)eResolveProxy(oldProperty);
      if (property != oldProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY, oldProperty, property));
      }
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyDefinition basicGetProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(PropertyDefinition newProperty)
  {
    PropertyDefinition oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY, oldProperty, property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyAssignmentRhs getRhs()
  {
    return rhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRhs(PropertyAssignmentRhs newRhs, NotificationChain msgs)
  {
    PropertyAssignmentRhs oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS, oldRhs, newRhs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRhs(PropertyAssignmentRhs newRhs)
  {
    if (newRhs != rhs)
    {
      NotificationChain msgs = null;
      if (rhs != null)
        msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS, null, msgs);
      if (newRhs != null)
        msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS, null, msgs);
      msgs = basicSetRhs(newRhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS, newRhs, newRhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE:
        return basicSetInstance(null, msgs);
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS:
        return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE:
        return getInstance();
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY_ENUM:
        return getPropertyEnum();
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS:
        return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE:
        setInstance((InstanceRef)newValue);
        return;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY_ENUM:
        setPropertyEnum((PropertyEnum)newValue);
        return;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY:
        setProperty((PropertyDefinition)newValue);
        return;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS:
        setRhs((PropertyAssignmentRhs)newValue);
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
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE:
        setInstance((InstanceRef)null);
        return;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY_ENUM:
        setPropertyEnum(PROPERTY_ENUM_EDEFAULT);
        return;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY:
        setProperty((PropertyDefinition)null);
        return;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS:
        setRhs((PropertyAssignmentRhs)null);
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
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__INSTANCE:
        return instance != null;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY_ENUM:
        return propertyEnum != PROPERTY_ENUM_EDEFAULT;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__PROPERTY:
        return property != null;
      case RdlPackage.POST_PROPERTY_ASSIGNMENT__RHS:
        return rhs != null;
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
    result.append(" (propertyEnum: ");
    result.append(propertyEnum);
    result.append(')');
    return result.toString();
  }

} //PostPropertyAssignmentImpl
