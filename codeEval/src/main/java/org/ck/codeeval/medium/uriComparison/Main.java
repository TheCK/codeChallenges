package org.ck.codeeval.medium.uriComparison;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 80, name = "URI Comparison", description = "Determine if two URIs match", url = "https://www.codeeval.com/open_challenges/80/", category = "Moderate challenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] values = line.split(";");

				URL uri1 = new URL(values[0]);
				URL uri2 = new URL(values[1]);

				boolean equals = true;

				if (uri1.getProtocol() != null)
				{
					if (!uri1.getProtocol().equalsIgnoreCase(uri2.getProtocol()))
					{
						equals = false;
					}
				}
				else
				{
					if (uri2.getProtocol() != null)
					{
						equals = false;
					}
				}

				if (uri1.getHost() != null)
				{
					if (!uri1.getHost().equalsIgnoreCase(uri2.getHost()))
					{
						equals = false;
					}
				}
				else
				{
					if (uri2.getHost() != null)
					{
						equals = false;
					}
				}

				int port1 = uri1.getPort();
				int port2 = uri2.getPort();

				if (port1 == -1)
				{
					port1 = 80;
				}
				if (port2 == -1)
				{
					port2 = 80;
				}
				if (port1 != port2)
				{
					equals = false;
				}

				if (uri1.getUserInfo() != null)
				{
					if (!uri1.getUserInfo().equalsIgnoreCase(uri2.getUserInfo()))
					{
						equals = false;
					}
				}
				else
				{
					if (uri2.getUserInfo() != null)
					{
						equals = false;
					}
				}

				String path1 = uri1.getPath();
				String path2 = uri2.getPath();

				try
				{
					if (path1 != null)
					{
						path1 = URLDecoder.decode(path1, "UTF-8");
					}
				}
				catch (IllegalArgumentException e)
				{
					//
				}
				try
				{
					if (path2 != null)
					{
						path2 = URLDecoder.decode(path2, "UTF-8");
					}
				}
				catch (IllegalArgumentException e)
				{
					//
				}

				if (path1 != null)
				{
					if (!path1.equals(path2))
					{
						equals = false;
					}
				}
				else
				{
					if (path2 != null)
					{
						equals = false;
					}
				}

				System.out.println(equals ? "True" : "False");
			}
		}
	}
}