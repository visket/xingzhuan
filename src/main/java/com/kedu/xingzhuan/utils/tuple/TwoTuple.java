package com.kedu.xingzhuan.utils.tuple;


/**
 * 元组，组定义返回参数，此类提供2个返回参数，顺序传入顺序取
 * @author around
 * @param <A> 1
 * @param <B> 2
 */
public class TwoTuple<A, B> {

	public final A a;
	
	public final B b;
	
	public TwoTuple(A a, B b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "TwoTuple [a=" + a + ", b=" + b + "]";
	}
	
	
}
