package Generator;

import java.util.HashSet;
import java.util.Random;

public class GameGenerator {

	private int [][] startTab;
	private int [][] tab;
	private Random r;
	private HashSet<Integer> numbers;
	
	public GameGenerator()
	{
		r = new Random();
		startTab = new int[9][9];
		tab = new int[9][9];
		numbers = new HashSet<>();
	}
	
	public String getValue(int x, int y)
	{
		return Integer.toString(tab[x][y]);
	}
	
	public void setValue(int x, int y, String value)
	{
		if (!value.equals(""))
		{
			int number = Integer.parseInt(value);
			startTab[x][y] = number;
		}
		else
			startTab[x][y] = 0;
	}
	
	private void numbersFill()
	{
		numbers.clear();
		
		for (int i = 0; i < 9; ++i)
			numbers.add(i + 1);
	}
	
	private void startFill()
	{
		for (int i = 0; i < startTab.length; ++i)
			for (int j = 0; j < startTab[i].length; ++j)
				tab[i][j] = startTab[i][j];
	}
	
	private void diagonalFill()
	{
		int number;
		
		startFill();
		
		newStart:
		for (int i = 0; i < 9; i += 3)
		{
			for (int j = i; j < i + 3; ++j)
			{
				for (int k = i; k < i + 3; ++k)
				{
					number = r.nextInt(9) + 1;
					
					if (tab[j][k] != 0)
					{
						continue;
					}
					else
					{
						if (possibilities(j, k) > 0)
						{
							while (!isPossible(number, j, k))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[j][k] = number;
						}
						else
						{
							startFill();
							continue newStart;
						}
					}
				}
			}
		}
	}
	
	private int possibilities(int x, int y)
	{
		int k = 0;
		int l = 0;
		
		if (x >= 0 && x < 3)
		{
			k = 0;
		}
		else if (x >= 3 && x < 6)
		{
			k = 3;
		}
		else if (x >= 6 && x < 9)
		{
			k = 6;
		}
		
		if (y >= 0 && y < 3)
		{
			l = 0;
		}
		else if (y >= 3 && y < 6)
		{
			l = 3;
		}
		else if (y >= 6 && y < 9)
		{
			l = 6;
		}
		
		numbersFill();
		
		for (int i = k; i < k + 3; ++i)
		{
			for (int j = l; j < l + 3; ++j)
			{
				if (numbers.contains(tab[i][j]))
				{
					numbers.remove(tab[i][j]);
				}
			}
		}
		
		for (int i = 0; i < 9 ; ++i)
		{
			if (numbers.contains(tab[i][y]))
			{
				numbers.remove(tab[i][y]);
			}
		}
		
		for (int i = 0; i < 9; ++i)
		{
			if (numbers.contains(tab[x][i]))
			{
				numbers.remove(tab[x][i]);
			}
		}
		
		return numbers.size();
	}
	
	private boolean isPossible(int number, int x, int y)
	{
		int k = 0;
		int l = 0;
		
		if (x >= 0 && x < 3)
		{
			k = 0;
		}
		else if (x >= 3 && x < 6)
		{
			k = 3;
		}
		else if (x >= 6 && x < 9)
		{
			k = 6;
		}
		
		if (y >= 0 && y < 3)
		{
			l = 0;
		}
		else if (y >= 3 && y < 6)
		{
			l = 3;
		}
		else if (y >= 6 && y < 9)
		{
			l = 6;
		}
		
		for (int i = k; i < k + 3; ++i)
		{
			for (int j = l; j < l + 3; ++j)
			{
				if (tab[i][j] == number)
				{
					return false;
				}
			}
		}
		
		for (int i = 0; i < 9 ; ++i)
		{
			if (tab[i][y] == number)
			{
				return false;
			}
		}
		
		for (int i = 0; i < 9; ++i)
		{
			if (tab[x][i] == number)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void start()
	{
		boolean gate = true;
		int number;
		
		newCreate:
		while (gate)
		{						
			//diagonalFill();
			
			startFill();
			
			for (int i = 0; i < 3; ++i)
			{
				for (int j = 3; j < 6; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 0; i < 3; ++i)
			{
				for (int j = 0; j < 3; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 0; i < 3; ++i)
			{
				for (int j = 6; j < 9; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 3; i < 6; ++i)
			{
				for (int j = 0; j < 3; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 3; i < 6; ++i)
			{
				for (int j = 3; j < 6; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 3; i < 6; ++i)
			{
				for (int j = 6; j < 9; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 6; i < 9; ++i)
			{
				for (int j = 0; j < 3; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 6; i < 9; ++i)
			{
				for (int j = 3; j < 6; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			for (int i = 6; i < 9; ++i)
			{
				for (int j = 6; j < 9; ++j)
				{
					if (tab[i][j] != 0)
					{
						continue;
					}
					else
					{
						number = r.nextInt(9) + 1;
						
						if (possibilities(i, j) > 0)
						{
							while (!isPossible(number, i, j))
							{
								number = r.nextInt(9) + 1;
							}
							
							tab[i][j] = number;
						}
						else
						{
							continue newCreate;
						}
					}
				}
			}
			
			gate = false;
		}
	}
}












