package Programmers;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int treeArrayLength = skill_trees.length;

        for(int i = 0; i < treeArrayLength; i++){
            int counter = 0;
            boolean flag = true;

            int skillTreeLength = skill_trees[i].length();
            for(int j = 0; j < skillTreeLength; j++){
                int skillLength = skill.length();

                for(int k = counter; k < skillLength; k++){
                    if(skill.charAt(k) == skill_trees[i].charAt(j)){
                        if(k != counter){
                            flag = false;
                        }else{
                            counter++;
                        }

                    }
                }
            }

            if(flag){
                answer++;
            }
        }

        return answer;
    }
}
