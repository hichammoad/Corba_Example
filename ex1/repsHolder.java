package ex1;


/**
* ex1/repsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from if_question.idl
* Thursday, December 16, 2021 10:15:51 AM WEST
*/

public final class repsHolder implements org.omg.CORBA.portable.Streamable
{
  public ex1.Response value[] = null;

  public repsHolder ()
  {
  }

  public repsHolder (ex1.Response[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ex1.repsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ex1.repsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ex1.repsHelper.type ();
  }

}