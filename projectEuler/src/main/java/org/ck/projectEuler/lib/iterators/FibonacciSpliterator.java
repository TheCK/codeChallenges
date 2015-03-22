package org.ck.projectEuler.lib.iterators;

import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public class FibonacciSpliterator extends Spliterators.AbstractLongSpliterator
{
	private long penultimate = 0;
	private long ultimate = 1;

	private long maxValue = Long.MAX_VALUE;
	
	public FibonacciSpliterator(int maxValue)
	{
		super(maxValue, 0);
		
		this.maxValue = maxValue;
	}

	@Override
	public boolean tryAdvance(LongConsumer action)
	{
		Long result = getNextValue();
		
		if (result != null)
		{
			action.accept(result);
		}
		
		return result != null;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Long> action)
	{
		Long result = getNextValue();
		
		
		if (result != null)
		{
			action.accept(result);
		}
		
		return result != null;
	}

	private Long getNextValue()
	{
		Long result = this.penultimate + this.ultimate;
		
		this.penultimate = this.ultimate;
		this.ultimate = result;
		
		if (result > this.maxValue)
		{
			return null;
		}
		
		return result;
	}
}