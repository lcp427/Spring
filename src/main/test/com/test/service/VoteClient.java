package com.test.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class VoteClient {
	static String requestUrl="http://nvshen.63.jycsu.com/plugin.php?id=tom_weixin_vote&mod=info&vid=4&tid=";
	static String Your_Http_Agent_Value="Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Mobile/9B176 MicroMessenger/4.3.2";
	static String COOKIE = "";  
	/*
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static String HttpRequest(String requestUrl, String requestMethod, String outputStr,String CookIEMod,String IP) throws ConnectException,Exception {
		String sTr="";
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			//30秒超时设置
			httpUrlConn.setConnectTimeout(30000);
			httpUrlConn.setReadTimeout(30000);
			
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setRequestProperty("User-Agent", Your_Http_Agent_Value);
			
			//伪造IP
			if (IP!=null){
			httpUrlConn.setRequestProperty("X-Forwarded-For",IP);
			httpUrlConn.setRequestProperty("HTTP_X_FORWARDED_FOR",IP);
			httpUrlConn.setRequestProperty("HTTP_CLIENT_IP",IP);
			httpUrlConn.setRequestProperty("REMOTE_ADDR",IP);
			}
			
			//设置COOKIE
			if (CookIEMod=="SET"){
				if(!COOKIE.equals("")){ 
					httpUrlConn.setRequestProperty("Cookie", COOKIE);  
	            } 
			}
			
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			
			if (CookIEMod=="GET"){
				COOKIE="";
		        String cookieVal = null;  
		        String key=null;
				 for (int i = 1; (key = httpUrlConn.getHeaderFieldKey(i)) != null; i++ ) {  
	                    if (key.equalsIgnoreCase("set-cookie")) {  
	                        cookieVal = httpUrlConn.getHeaderField(i);  
	                        cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));  
	                        COOKIE = COOKIE+cookieVal+";";  
	                    }  
	                }  
//				 System.out.println("SET COOKIE="+COOKIE);
			}
			
			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			sTr = buffer.toString();
			
		} catch (Exception e) {
	    	e.printStackTrace();
	    	throw new Exception("http请求失败："+e.getMessage());
		}
		return sTr;
	}
	
	 /**
	  * 随机返回几位数
	  * @param num
	  * @return
	  */
	 public static String getRandomStr(int num){
			
			String str = "0123456789";
			Random random = new Random(); 
			String strResult;
			strResult = "";
			for(int i=0;i<num;i++){			
				Integer rInt= random.nextInt(10);
				strResult = strResult + str.substring(rInt, rInt+1);	
			}		
			return strResult;
	}

	 public static String getRandomIp(){
         
	        //ip范围
	        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
	                         {1038614528,1039007743},//61.232.0.0-61.237.255.255
	                         {1783627776,1784676351},//106.80.0.0-106.95.255.255
	                         {2035023872,2035154943},//121.76.0.0-121.77.255.255
	                         {2078801920,2079064063},//123.232.0.0-123.235.255.255
	                         {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
	                         {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
	                         {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
	                         {-770113536,-768606209},//210.25.0.0-210.47.255.255
	                         {-569376768,-564133889}, //222.16.0.0-222.95.255.255
	        };
	         
	        Random rdint = new Random();
	        int index = rdint.nextInt(10);
	        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
	        return ip;
	 }
	 
	 /*
     * 将十进制转换成ip地址
     */
    public static String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";
         
        b[0] = (int)((ip >> 24) & 0xff);
        b[1] = (int)((ip >> 16) & 0xff);
        b[2] = (int)((ip >> 8) & 0xff);
        b[3] = (int)(ip & 0xff);
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]); 
         
        return x; 
     }
	    
	public static void main(String[] args) {
		try {
			String[] tid={"20","21","22","23","24","26","27"};//25
			for(int i=1;i<2000;i++){
				
				for(int j=0;j<7;j++){
				String tptel="131"+getRandomStr(8);
				String IP=getRandomIp();
				//获取投票页面数据
				String RequestStr=HttpRequest(requestUrl+tid[j], "GET", null,"GET",IP);
				int formhashint=RequestStr.indexOf("name=\"formhash\" value=\"")+23;
				int tomhashint=RequestStr.indexOf("name=\"tomhash\" value=\"")+22;
				String formhashStr=RequestStr.substring(formhashint,formhashint+10);
				formhashStr=formhashStr.substring(0,formhashStr.indexOf("\""));
				String tomhashStr=RequestStr.substring(tomhashint,tomhashint+10);
				tomhashStr=tomhashStr.substring(0,tomhashStr.indexOf("\""));
	//			System.out.println("formhashStr="+formhashStr+";tomhashStr="+tomhashStr);
				
				//初始化记录投票
				String SaveUrl="http://nvshen.63.jycsu.com/plugin.php?id=tom_weixin_vote&mod=save&act=clicks&formhash="+formhashStr+"&vid=4";
	//			System.out.println("SaveUrl="+SaveUrl);
				String SaveStr=HttpRequest(SaveUrl, "GET", null,"SET",IP);
				
				//开始调用投票页面
				String voteUrl="http://nvshen.63.jycsu.com/plugin.php?id=tom_weixin_vote&mod=save&tpxm=tom&tptel="+tptel+"&formhash="+formhashStr+"&tomhash="+tomhashStr+"&vid=4&tid="+tid[j]+"&act=tpadd";
	//			System.out.println("voteUrl="+voteUrl);
				String RequestStr2=HttpRequest(voteUrl, "GET", null,"SET",IP);
				System.out.println("IP="+IP+";"+RequestStr2);
				Random random = new Random(); 
				Thread.sleep(random.nextInt(1)*500);
				}
			}
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
