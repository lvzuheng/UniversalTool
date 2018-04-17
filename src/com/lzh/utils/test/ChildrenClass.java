package com.lzh.utils.test;

public abstract class ChildrenClass extends ParentClass{

	static{
		System.out.println("children");
	}
	public static int vlu = 333;

	public abstract void sss();
}
