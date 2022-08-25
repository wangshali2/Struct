package com.atguigu.day05.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * ̰���㷨
 */
public class GreedyAlgorithm {

	public static void main(String[] args) {
		//�����㲥��̨,���뵽Map<k,set(����1���ĵ���2...)>
		HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();

		//��������̨k1,k2,k3,k4,k5���뵽broadcasts
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("����");
		hashSet1.add("�Ϻ�");
		hashSet1.add("���");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("����");
		hashSet2.add("����");
		hashSet2.add("����");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("�ɶ�");
		hashSet3.add("�Ϻ�");
		hashSet3.add("����");
		
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("�Ϻ�");
		hashSet4.add("���");
		
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("����");
		hashSet5.add("����");
	
		//���뵽map
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		
		//allAreas ������еĵ��������ǵ��Ļ��Ƴ������µ�˵����δ���ǵ���
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("����");
		allAreas.add("�Ϻ�");
		allAreas.add("���");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("�ɶ�");
		allAreas.add("����");
		allAreas.add("����");
		
		//����ArrayList, ���Ҫѡ��ĵ�̨����
		ArrayList<String> selects = new ArrayList<String>();
		
		//����һ����ʱ�ļ��ϣ� �ڱ�����̨K�Ĺ����У���ŵ�̨���ǵĵ���Set��allArea(δ����)�Ľ���
		HashSet<String> tempSet = new HashSet<String>();
		
		//�����maxKey �� ������һ�α��������У��ܹ��������δ���ǵĵ�����Ӧ�ĵ�̨��key
		String maxKey = null;
		while(allAreas.size() != 0) { //allAreas��ʾû�и��ǵ��ĵ���
			//ÿ����һ��while,��Ҫ
			maxKey = null;
			
			//������̨K
			for(String key : broadcasts.keySet()) {
				//ÿ����һ��for
				tempSet.clear();
				//��ǰ���key�ܹ����ǵĵ���
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				//���tempSet ��   allAreas ���ϵĽ���, �����ḳ�� tempSet
				tempSet.retainAll(allAreas);
				//�����ǰ������ϰ�����δ���ǵ�������������maxKeyָ��ļ��ϵ�������,����Ҫ����maxKey
				if(tempSet.size() > 0 && (maxKey == null || tempSet.size() >broadcasts.get(maxKey).size())){
					maxKey = key;
				}
			}
			//maxKey != null, ��Ӧ�ý�maxKey ����selects
			if(maxKey != null) {   //K4ʱ maxKey == null
				selects.add(maxKey);
				//��maxKeyָ��Ĺ㲥��̨���ǵĵ������� allAreas ȥ��
				allAreas.removeAll(broadcasts.get(maxKey));
			}
			
		}
		
		System.out.println("�õ���ѡ������" + selects);//[K1,K2,K3,K5]
		
		
		
	}

}
