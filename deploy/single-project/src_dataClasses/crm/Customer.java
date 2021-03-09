package crm;

/**
 */
@SuppressWarnings("all")
@javax.annotation.processing.Generated(comments="This is the java file of the ivy data class Customer", value={"ch.ivyteam.ivy.scripting.streamInOut.IvyScriptJavaClassBuilder"})
@javax.persistence.Entity
@javax.persistence.Table(name="Customer")
public class Customer extends ch.ivyteam.ivy.scripting.objects.CompositeObject
{
  /** SerialVersionUID */
  private static final long serialVersionUID = -8178189645063661767L;

  /**
   * Identifier
   */
  @javax.persistence.Id
  @javax.persistence.GeneratedValue
  private java.lang.Integer id;

  /**
   * Gets the field id.
   * @return the value of the field id; may be null.
   */
  public java.lang.Integer getId()
  {
    return id;
  }

  /**
   * Sets the field id.
   * @param _id the new value of the field id.
   */
  public void setId(java.lang.Integer _id)
  {
    id = _id;
  }

  private java.lang.String firstname;

  /**
   * Gets the field firstname.
   * @return the value of the field firstname; may be null.
   */
  public java.lang.String getFirstname()
  {
    return firstname;
  }

  /**
   * Sets the field firstname.
   * @param _firstname the new value of the field firstname.
   */
  public void setFirstname(java.lang.String _firstname)
  {
    firstname = _firstname;
  }

  private java.lang.String lastname;

  /**
   * Gets the field lastname.
   * @return the value of the field lastname; may be null.
   */
  public java.lang.String getLastname()
  {
    return lastname;
  }

  /**
   * Sets the field lastname.
   * @param _lastname the new value of the field lastname.
   */
  public void setLastname(java.lang.String _lastname)
  {
    lastname = _lastname;
  }

  @org.hibernate.annotations.Type(type = "ch.ivyteam.ivy.process.data.persistence.usertype.DateUserType")
  private ch.ivyteam.ivy.scripting.objects.Date dateOfBirth;

  /**
   * Gets the field dateOfBirth.
   * @return the value of the field dateOfBirth; may be null.
   */
  public ch.ivyteam.ivy.scripting.objects.Date getDateOfBirth()
  {
    return dateOfBirth;
  }

  /**
   * Sets the field dateOfBirth.
   * @param _dateOfBirth the new value of the field dateOfBirth.
   */
  public void setDateOfBirth(ch.ivyteam.ivy.scripting.objects.Date _dateOfBirth)
  {
    dateOfBirth = _dateOfBirth;
  }

}
