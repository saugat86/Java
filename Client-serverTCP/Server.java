import java.io.*;
import java.net.*;
class Server
{
            public static void main(String args[])
            {
                        try
                        {
                                    ServerSocket ss=new ServerSocket(1064);
                                    System.out.println("Waiting for Client Request");
                                    Socket s=ss.accept();
                                    BufferedReader br;
                                    PrintStream ps;
                                    String str;
                                    br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                                    str=br.readLine();
                                    System.out.println("Received number");
                                    int x=Integer.parseInt(str);
                                    int fact=1;
                                    for(int i=1;i<=x;i++)
                                    fact=fact*i;
                                    
                                    ps=new PrintStream(s.getOutputStream());
                                    ps.println(String.valueOf(fact));
                                    br.close();
                                    ps.close();
                                    s.close();
                                    ss.close();
                        }
                        catch(Exception e)
                        {
                                    System.out.println(e);
                        }
            }
}