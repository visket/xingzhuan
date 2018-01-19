package com.kedu.xingzhuan.utils.tuple;


/**
 * 元组，组定义返回参数，此类提供3个返回参数，顺序传入顺序取
 * @author around
 * @param <A> 1
 * @param <B> 2
 * @param <C> 3
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

	public final C c;
	
	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		this.c = c;
	}

	@Override
	public String toString() {
		return "ThreeTuple [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
