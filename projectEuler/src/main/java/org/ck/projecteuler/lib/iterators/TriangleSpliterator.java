package org.ck.projecteuler.lib.iterators;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class TriangleSpliterator extends Spliterators.AbstractIntSpliterator
{
	private Queue<Integer> triangles = new LinkedList<>();
	
	public TriangleSpliterator(int minValue, int maxValue)
	{
		super(maxValue, 0);
		
		generateTriangles(minValue, maxValue);
	}

	private void generateTriangles(int minValue, int maxValue)
	{
		int triangle = 1;
		int i = 1;
		
		while (triangle <= maxValue)
		{
			if (triangle >= minValue)
			{
				this.triangles.add(triangle);
			}
			
			triangle += ++i;
		}
	}

	@Override
	public boolean tryAdvance(IntConsumer action)
	{
		if (this.triangles.isEmpty())
		{
			return false;
		}
		
		action.accept(this.triangles.remove());
		
		return true;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Integer> action)
	{
		if (this.triangles.isEmpty())
		{
			return false;
		}
		
		action.accept(this.triangles.remove());
		
		return true;
	}
}