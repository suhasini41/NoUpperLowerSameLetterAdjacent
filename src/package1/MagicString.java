package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MagicString 
{
	private String generateMagicString(String s)
	{
		String s1 = null;
		while(true)
		{
			s1 = magicStr(s);
			if(s.length()==s1.length())
			{
				System.out.println(s1);
				break;
			}
			else
			{
				s = magicStr(s1);
			}
		}
		return s1;
	}

	private String magicStr(String s) {
		char[] ch = s.toCharArray();
		String s1 = "";
		for(int i=0;i<ch.length;i++)
		{
			if(i<ch.length-1)
			{
				if(Character.isLowerCase(ch[i])&&(ch[i]==Character.toLowerCase(ch[i+1]))&&(Character.isUpperCase(ch[i+1])))
				{
					i++;
				}
				else if(Character.isUpperCase(ch[i])&&(ch[i]==Character.toUpperCase(ch[i+1]))&&(Character.isLowerCase(ch[i+1])))
				{
					i++;
				}
				else
				{
					s1 = s1 + ch[i];
				}
			}
			else if(i==ch.length-1)
			{
				s1 = s1 + ch[i];
			}
		}
		return s1;
	}
	
	@Test
	public void testCase1()
	{
		Assert.assertEquals(generateMagicString("abBAcC"), "");
	}
	
	@Test
	public void testCase2()
	{
		Assert.assertEquals(generateMagicString("ninja"), "ninja");
	}
	
	@Test
	public void testCase3()
	{
		Assert.assertEquals(generateMagicString("sweeEet"), "sweet");
	}
	
	@Test
	public void testCase4()
	{
		Assert.assertEquals(generateMagicString("codeE"), "cod");
	}

}
