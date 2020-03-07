小y的Java学习笔记

1、构造函数：对象一旦建立就会调用与之对应的构造函数
2、构造代码块：
    作用：给对象进行初始化
    对象一建立就运行，且优先于构造函数执行
    和构造函数的区别：构造代码块是给所有对象进行统一初始化
    而构造函数是给对应对象初始化

3、this关键字：this代表它所在函数所属对象的引用
简单说：哪个对象在调用this所在的函数，this就代表哪个对象（每个教师又一张椅子属于老师，谁过来上课，椅子属于谁）

4、this的应用：当定义类中功能时，该函数内部要用到调用该函数的对象时，这时用this来表示这个对象。
（看到this想到：这是一个对象的引用，this和p1的地址值相同，指向了同一个对象）

5、this语句 this()：构造函数之间相互调用只能用给this语句 this语句只能定义在构造函数的第一行，因为初始化要先执行
this语句不能用在一般函数中

6、静态static：用于修饰成员（成员变量、成员函数），静态修饰内容被对象所共享，当成员被静态修饰后，就对了一个调用方式，除了可以被对象调用之外，还可以被类名直接调用。
类名.静态成员

7、static的特点
    1.随着类的加载而加载，也就是说静态会随着类的消失而消失。说明它的生命周期最长
    2.优先于对象存在，静态先存在，对象后存在
    3.被所有对象共享
    4.可以被类名直接调用

8、实例变量（成员变量）和类变量（静态成员变量）的区别：
    1.存放位置：类变量随着类的加载存放在方法区当中
               实例变量随着对象的建立而存在于堆内存当中
    2.生命周期：类变量生命周期最长，随着类的消失而消失
               实例变量生命周期随着对象的消失而消失

9、静态使用注意事项：
    1.静态方法只能访问静态成员（静态方法静态变量）。非静态方案既可以访问静态也可以访问非静态。
    2.静态方法中不可以定义this，super关键字。因为静态优先于对象存在，所以静态方法中不可以出现this、super
    3.主函数是静态的
        主函数：是一个特殊的函数，作为程序的入口，可以被jvm调用。

        主函数的定义：
        public：代表该函数的访问权限是最大的
        static：代表主函数随着类的加载就已经存在了
        void：主函数没有具体的返回值
        main：不是关键字，但是是一个特殊的单词，可以被jvm识别
        函数的参数：（String[] args），是一个数组，字符串类型的数组
        主函数是固定格式的：jvm识别
        jvm在调用主函数时，传入的是new String[0]
        java +类名 +参数
10、静态有利有弊
    1.利：对对象的共享数据进行单独空间的存储，节省空间。没有必要每个对象中都存储一份。
          可以直接被类名调用。
    2.弊：生命周期过长
          访问出现局限性（静态虽好，只能访问静态）

11、什么时候使用静态static？
    要从两方面下手（因为静态修饰的内容有成员变量和函数）：
    1.什么时候定义静态变量：当对象中出现共享数据时，该数据被静态所修饰，存在于共享区，特有数据要定义成非静态，存在于堆内存中。
    2.什么时候定义静态函数：当功能内部没有访问到非静态数据（对象的特有数据），那么该功能可以定义成静态。

12、默认构造函数的权限是随着类的变化而变化的

13、静态代码块：随着类的加载而执行，只执行一次

14、Person p = new Person("zhangsan",20)
    该句话都做了什么事情？
    1.因为new用到了Person.class，所以会先找到Person.class文件并加载到内存中。
    2.执行该类中的static静态代码块，如果有的话，给Person.class类进行初始化。
    3.在堆内存中开辟空间，分配内存地址。
    4.在堆内存中建立对象特有的属性，并进行默认初始化。
    5.对对象进行构造代码块的初始化。
    7.对对象进行构造函数初始化。
    8.将内存地址赋给栈内存中的P变量。
    （默认初始化->显式初始化->构造代码块初始化->构造函数初始化）

15、单例设计模式：解决一个类在内存中只存在一个对象
        1.为了避免其他程序过多建立该类对象，先禁止其他程序建立该对象（将构造函数私有化）
        2.还为了让其他程序可以访问到该类对象，只好在本类中自定义一个对象（在类中创建一个本类对象）
        3.对了方便其他程序对自定义对象的访问，可以对外提供一些访问方式（对外提供公有方法访问该对象）
    饿汉式：先初始化对象，类一进内存，就已经创建好了对象
    懒汉式：方法被调用时，才初始化对象

16、重载：只看同名函数的参数列表；
    重写：子父类方法要一模一样

17、在对子类对象进行初始化时，父类的构造函数也会运行，因为子类的构造函数默认第一行有一条隐式的super()

18、final：
    1.可以修饰类、函数、变量
    2.被final修饰的类不可以被继承
    3.被final修饰的方法不可以被复写
    4.被final修饰的变量是一个常量只能赋值一次

19、抽象：就是看不懂
    抽象类的特点：
    1.抽象方法一定在抽象类中
    2.抽象方法和抽象类必须被abstract关键字修饰
    3.抽象类不可以用new创建对象，因为调用抽象方法没意义
    4.抽象类中的方法要被使用，必须由子类腹泻其所有的抽象方法后，建立子类对象，来调用。
        如果子类只覆盖了部分抽象方法，那么该子类还是一个抽象类。
20、接口：初期理解，可以认为是一个特殊的抽象类，当抽象类中的方法都是抽象的，那么类可以通过接口来表示
    interface用于定义接口
    接口定义时格式特点：常量：public static final
                        方法：public abstract
    记住：接口中的成员都是public的
21、多态：
    1.多态的体现：父类的引用指向了子类对象
    2.多态的前提：必须类与类之间有关系，要么继承，要么实现
                 通常还有一个前提，存在子类覆盖
    3.多态的好处：大大提高了程序的扩展性
    4.多态的弊端：只能使用父类的引用访问父类中的成员
22、异常
    try
    {
        需要被检测的代码
    }
    catch(异常类 变量)
    {
        处理异常的代码
    }
    finally
    {
        一定会执行的语句
    }
    其实jvm默认的异常处理机制，就是在调用printStackTrace()方法，打印异常的堆栈跟踪信息
23、throw和throws的区别
    throws后面跟着异常类，可以跟多个，用逗号隔开
    throw后面跟的是异常对象
    throws使用在函数上
    Throw使用在函数内
    class Demo
    {
        int div(int a,int b)throws FuShuException
        {
            if(b<0)
            throw new FuShuException("出现了除数是负数的情况")
            return a/b;
        }
    }
24、Exception中有一个特殊的子类异常RuntimeException运行时异常
    如果在函数内容抛出该异常，函数上可以不用声明，编译一样通过
    如果在函数上声明了该异常，调用者可以不用进行处理，编译一样通过
    之所以不用再函数伤命，是因为不需要让调用者处理
    当该异常发生时，希望程序停止运行，因为在运行时出现了无法继续运算的情况，希望停止程序后，对代码进行修正
25、字符流和字节流
    字节流两个基类：InputStream OutStream
    字符流两个基类：Reader Writer
    fw.close()和fw.flush的区别 
        flush刷新流，将流中的内容写入文件，刷新后流可以继续使用
        close关闭流，在关闭之前刷新流
26、读取一个Java文件，并打印在控制台上
    class FileReaderTest 
{
	public static void main(String[] args) throws IOException
	{
		FileReader  fr = new FileReader("DateDemo.java");

		char[] buf = new  char[1024];

		int num = 0;

		while((num=fr.read(buf))!=-1)//结束时 返回-1 以此判断
		{
			System.out.print(new String(buf,0,num));//num数组长度
		}

		fr.close();
	}

}
27、File类常见方法：
    1，创建。
        boolean createNewFile():在指定位置创建文件，如果该文件已经存在，则不创建，返回false。
                            和输出流不一样，输出流对象一建立创建文件。而且文件已经存在，会覆盖。

        boolean mkdir():创建文件夹。
        boolean mkdirs():创建多级文件夹。
    2，删除。
        boolean delete()：删除失败返回false。如果文件正在被使用，则删除不了返回falsel。
        void deleteOnExit();在程序退出时删除指定文件。


    3，判断。
        boolean exists() :文件是否存在.
        isFile():
        isDirectory();
        isHidden();
        isAbsolute();

    4，获取信息。
        getName():
        getPath():
        getParent():

        getAbsolutePath() 
        long lastModified() 
        long length() 

28、记住在判断文件对象是否是文件或者目的时，必须要先判断该文件对象封装的内容是否存在。
	通过exists判断。
29、字符流：
        FileReader
        FileWriter。

        BufferedReader
        BufferedWriter

    字节流：
        FileInputStream
        FileOutputStream

        BufferedInputStream
        BufferedOutputStream

30、！！！获取键盘录入对象。
		InputStream in = System.in;

		将字节流对象转成字符流对象，使用转换流。InputStreamReader
		InputStreamReader isr = new InputStreamReader(in);

		为了提高效率，将字符串进行缓冲区技术高效操作。使用BufferedReader

		BufferedReader bufr = new BufferedReader(isr);


		键盘的最常见写法(上面三句话合成一句话)。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
    
31、1，明确源和目的
        源：输入流。InputStream  Reader
        目的：输出流。OutputStream  Writer
    2，操作的数据是否是纯文本
        是：字符流
        不是：字节流

32、StringBuffer是一个容器 区间参数左闭右开 如[2,3]取2
    1，存储。
	StringBuffer append():将指定数据作为参数添加到已有数据结尾处。
	StringBuffer insert(index,数据):可以将数据插入到指定index位置。

    2，删除。
        StringBuffer delete(start,end):删除缓冲区中的数据，包含start，不包含end。
        StringBuffer deleteCharAt(index):删除指定位置的字符。
        
    3，获取。
        char charAt(int index) 
        int indexOf(String str) 
        int lastIndexOf(String str) 
        int length() 
        String substring(int start, int end) 
    
    4，修改。
        StringBuffer replace(start,end,string);
        void setCharAt(int index, char ch) ;


    5，反转。
        StringBuffer reverse();
    
    6，
        将缓冲区中指定数据存储到指定字符数组中。
        void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 

33、基本数据类型对象包装类
        byte	Byte
        short	Short
        int		Integer
        long	Long
        boolean Boolean
        float	Float
        double	Double
        char	Character

33、基本数据类型对象包装类的最常见作用，
    就是用于基本数据类型和字符串类型之间做转换

    基本数据类型转成字符串。

        基本数据类型+""

        基本数据类型.toString(基本数据类型值);

        如： Integer.toString(34);//将34整数变成"34";


    字符串转成基本数据类型。

        xxx a = Xxx.parseXxx(String);

        int a = Integer.parseInt("123");

        double b = Double.parseDouble("12.23");

        boolean b = Boolean.parseBoolean("true");

        Integer i = new Integer("123");

        int num = i.intValue();

        


    十进制转成其他进制。
        toBinaryString();
        toHexString();
        toOctalString();


    其他进制转成十进制。
        parseInt(string,radix);

34、IP地址：InetAddress

35、UDP 面向无连接 不论你在不在线，我就是发
        每个数据报的大小限制在64K内
        因无连接，是不可靠的传输协议
        不需要建立连接，速度快

36、TCP 建立连接 形成传输数据的通道
        在连接中大量传输数据
        通过三次握手链接，是可靠协议
        必须建立连接，效率会降低

37、DatagramPacket 数据报包

38、socket编程 主要记住流程，代码可以查阅文档

39、UDP：
    //1，创建udp服务。通过DatagramSocket对象。
    DatagramSocket ds = new DatagramSocket(8888);

    //2，确定数据，并封装成数据包。DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
    byte[] buf = "udp ge men lai le ".getBytes();
    DatagramPacket dp = 
        new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.254"),10000);

    //3，通过socket服务，将已有的数据包发送出去。通过send方法。
    ds.send(dp);

    //4，关闭资源。
    ds.close();

40、TCP：
    1,tcp分客户端和服务端。
    2，客户端对应的对象是Socket。
	   服务端对应的对象是ServerSocket。




----------Java web----------
41、Junit使用：白盒测试
		* 步骤：
			1. 定义一个测试类(测试用例)
				* 建议：
					* 测试类名：被测试的类名Test		CalculatorTest
					* 包名：xxx.xxx.xx.test		cn.itcast.test

			2. 定义测试方法：可以独立运行
				* 建议：
					* 方法名：test测试的方法名		testAdd()  
					* 返回值：void
					* 参数列表：空参

			3. 给方法加@Test
			4. 导入junit依赖环境

		* 判定结果：
			* 红色：失败
			* 绿色：成功
			* 一般我们会使用断言操作来处理结果
				* Assert.assertEquals(期望的结果,运算的结果);

		* 补充：
			* @Before:
				* 修饰的方法会在测试方法之前被自动执行
			* @After:
				* 修饰的方法会在测试方法执行之后自动被执行

42、## 反射：框架设计的灵魂
	* 框架：半成品软件。可以在框架的基础上进行软件开发，简化编码
	* 反射：将类的各个组成部分封装为其他对象，这就是反射机制
		* 好处：
			1. 可以在程序运行过程中，操作这些对象。
			2. 可以解耦，提高程序的可扩展性。


	* 获取Class对象的方式：
		1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
			* 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
		2. 类名.class：通过类名的属性class获取
			* 多用于参数的传递
		3. 对象.getClass()：getClass()方法在Object类中定义着。
			* 多用于对象的获取字节码的方式

		* 结论：
			同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。

43、* Class对象功能：
		* 获取功能：
			1. 获取成员变量们
				* Field[] getFields() ：获取所有public修饰的成员变量
				* Field getField(String name)   获取指定名称的 public修饰的成员变量

				* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
				* Field getDeclaredField(String name)  
			2. 获取构造方法们
				* Constructor<?>[] getConstructors()  
				* Constructor<T> getConstructor(类<?>... parameterTypes)  

				* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)  
				* Constructor<?>[] getDeclaredConstructors()  
			3. 获取成员方法们：
				* Method[] getMethods()  
				* Method getMethod(String name, 类<?>... parameterTypes)  

				* Method[] getDeclaredMethods()  
				* Method getDeclaredMethod(String name, 类<?>... parameterTypes)  

			4. 获取全类名	
				* String getName()  


	* Field：成员变量
		* 操作：
			1. 设置值
				* void set(Object obj, Object value)  
			2. 获取值
				* get(Object obj) 

			3. 忽略访问权限修饰符的安全检查
				* setAccessible(true):暴力反射



	* Constructor:构造方法
		* 创建对象：
			* T newInstance(Object... initargs)  

			* 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法


	* Method：方法对象
		* 执行方法：
			* Object invoke(Object obj, Object... args)  

		* 获取方法名称：
			* String getName:获取方法名
44、## 注解：
	* 概念：说明程序的。给计算机看的
	* 注释：用文字描述程序的。给程序员看的

	* 定义：注解（Annotation），也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。
	* 概念描述：
		* JDK1.5之后的新特性
		* 说明程序的
		* 使用注解：@注解名称
		
	
	* 作用分类：
		①编写文档：通过代码里标识的注解生成文档【生成文档doc文档】
		②代码分析：通过代码里标识的注解对代码进行分析【使用反射】
		③编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】


	* JDK中预定义的一些注解
		* @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
		* @Deprecated：该注解标注的内容，表示已过时
		* @SuppressWarnings：压制警告
			* 一般传递参数all  @SuppressWarnings("all")

	* 自定义注解
		* 格式：
			元注解
			public @interface 注解名称{
				属性列表;
			}

		* 本质：注解本质上就是一个接口，该接口默认继承Annotation接口
			* public interface MyAnno extends java.lang.annotation.Annotation {}

		* 属性：接口中的抽象方法
			* 要求：
				1. 属性的返回值类型有下列取值
					* 基本数据类型
					* String
					* 枚举
					* 注解
					* 以上类型的数组

				2. 定义了属性，在使用时需要给属性赋值
					1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
					2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
					3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
		
		* 元注解：用于描述注解的注解
			* @Target：描述注解能够作用的位置
				* ElementType取值：
					* TYPE：可以作用于类上
					* METHOD：可以作用于方法上
					* FIELD：可以作用于成员变量上
			* @Retention：描述注解被保留的阶段
				* @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
			* @Documented：描述注解是否被抽取到api文档中
			* @Inherited：描述注解是否被子类继承


	* 在程序使用(解析)注解：获取注解中定义的属性值
		1. 获取注解定义的位置的对象  （Class，Method,Field）
		2. 获取指定的注解
			* getAnnotation(Class)
			//其实就是在内存中生成了一个该注解接口的子类实现对象

		            public class ProImpl implements Pro{
		                public String className(){
		                    return "cn.itcast.annotation.Demo1";
		                }
		                public String methodName(){
		                    return "show";
		                }
		            }
		3. 调用注解中的抽象方法获取配置的属性值
	

	* 案例：简单的测试框架
	* 小结：
		1. 以后大多数时候，我们会使用注解，而不是自定义注解
		2. 注解给谁用？
			1. 编译器
			2. 给解析程序用
		3. 注解不是程序的一部分，可以理解为注解就是一个标签