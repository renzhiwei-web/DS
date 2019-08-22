package com.DS.sort;

public class ShellMv implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		/*int index;
		for(int gap = demo.length / 2;gap > 0;gap /= 2){
			for(int i = gap;i < demo.length;i++){
				for(int j = i - gap;j < i;j += gap){
					if (demo[i] < demo[j]) {
						index = demo[i];
						for(int y = i;y > j;y -= gap){
							demo[y] = demo[y - gap];
						}
						demo[j] = index;
					}
				}
			}
		}*/
		for (int gap = demo.length / 2; gap > 0; gap /= 2) {
			for(int i = gap;i < demo.length;i++){
				int j = i;
				int temp = demo[j];
				if (demo[j] < demo[j - gap]) {
					while(j - gap >= 0 && temp < demo[j - gap]){
						demo[j] = demo[j - gap];
						j -= gap;
					}
					demo[j] = temp;
				}
			}
		}
	}

}
