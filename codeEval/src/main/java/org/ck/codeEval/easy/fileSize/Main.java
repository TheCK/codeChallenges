package org.ck.codeEval.easy.fileSize;

import java.io.File;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 26, name = "File Size", description = "Print the file size in bytes.", url = "https://www.codeeval.com/open_challenges/26/", category = "Easy challenges")
public class Main
{
	public static void main(String[] args)
	{
		File file = new File(args[0]);

		System.out.println(file.length());
	}
}
