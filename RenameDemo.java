import java.io.*;

class RenameDemo
{
    public static void main(String[] args)
    {
        getName();
    }

    public static void getName()
    {
        File dir = new File("C:\\Users\\43859\\Desktop\\ѧϰ\\����25��part1\\��25��");
        String[] files= dir.list();
        File[] files2 = dir.listFiles();
        for(File f:files2)
        {
            String filename = f.getName();
            File name = new File(dir.getAbsolutePath()+"\\"+filename.substring(25,f.getName().length()));
            f.renameTo(name);
           sop(dir.getAbsolutePath()+"\\"+filename.substring(25,f.getName().length()));
        }
    }

    public static void sop(String s)
    {
        System.out.println(s);
    }

}