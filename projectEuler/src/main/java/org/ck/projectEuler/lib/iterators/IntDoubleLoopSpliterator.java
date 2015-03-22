package org.ck.projectEuler.lib.iterators;

import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;

public class IntDoubleLoopSpliterator extends Spliterators.AbstractIntSpliterator
{
	private int start1 = 0;
	private int start2 = 0;
	private int end1 = Integer.MAX_VALUE;
	private int end2 = Integer.MAX_VALUE;
	
	private IntUnaryOperator countFunction;
	private IntBinaryOperator resultFunction;
	
	private int i = 0;
	private int j = 0;
	
	public IntDoubleLoopSpliterator(int start1, int end1, int start2, int end2, IntUnaryOperator countFunction, IntBinaryOperator resultFunction)
	{
		super(Integer.MAX_VALUE, 0);
		
		this.start1 = start1;
		this.end1 = end1;
		
		this.start2 = start2;
		this.end2 = end2;
		
		this.countFunction = countFunction;
		this.resultFunction = resultFunction;
		
		this.i = this.start1;
		this.j = this.start2;
	}

	@Override
	public boolean tryAdvance(IntConsumer action)
	{
		Integer result = getNextValue();
		
		if (result != null)
		{
			action.accept(result);
		}
		
		return result != null;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Integer> action)
	{
		Integer result = getNextValue();
		
		if (result != null)
		{
			action.accept(result);
		}
		
		return result != null;
	}

	private Integer getNextValue()
	{
		if (this.i == this.end1)
		{
			return null;
		}
		
		Integer result = this.resultFunction.applyAsInt(this.i, this.j);
		
		this.j = this.countFunction.applyAsInt(this.j);
		
		if (this.j == this.end2)
		{
			this.j = this.start2;
			this.i = this.countFunction.applyAsInt(this.i);
		}
		
		return result;
	}
}