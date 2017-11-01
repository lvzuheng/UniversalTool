package com.lzh.utils.net;

public class netMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContrastsIP contrastsIP = new ContrastsIP();
//		contrastsIP.contrasts("10.11.33.70");
		System.out.println(contrastsIP.getInetAddress().getHostAddress());
	}

}
