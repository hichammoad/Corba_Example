package ex1.AppPackage;


/**
* ex1/AppPackage/qlistHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from if_question.idl
* Thursday, December 16, 2021 10:15:51 AM WEST
*/

abstract public class qlistHelper
{
  private static String  _id = "IDL:ex1/App/qlist:1.0";

  public static void insert (org.omg.CORBA.Any a, ex1.Question[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ex1.Question[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ex1.QuestionHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ex1.AppPackage.qsHelper.id (), "qs", __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ex1.AppPackage.qlistHelper.id (), "qlist", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ex1.Question[] read (org.omg.CORBA.portable.InputStream istream)
  {
    ex1.Question value[] = null;
    int _len0 = istream.read_long ();
    value = new ex1.Question[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = ex1.AppPackage.qsHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ex1.Question[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      ex1.AppPackage.qsHelper.write (ostream, value[_i0]);
  }

}
