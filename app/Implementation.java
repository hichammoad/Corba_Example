package app;

import java.util.ArrayList;
import java.util.List;

import ex1.AppPOA;
import ex1.Question;
import ex1.Response;

public class Implementation extends AppPOA {
	List<Question> questionsList;

	public Implementation() {
		questionsList = new ArrayList<Question>();

		Response reps1[] = new Response[3];
		reps1[0] = new Response(11, "Common object...", true);
		reps1[1] = new Response(12, "langage de programmation", false);
		reps1[2] = new Response(13, "IDE", false);
		Question q1 = new Question(1, "What is corba?", reps1);

		Response reps2[] = new Response[3];
		reps2[0] = new Response(21, "Common object...", false);
		reps2[1] = new Response(22, "langage de programmation", false);
		reps2[2] = new Response(23, "REMOtE MEthode invokation", true);
		Question q2 = new Question(2, "What is RMI?", reps2);

		questionsList.add(q1);
		questionsList.add(q2);

	}

	@Override
	public Question[] getquestions() {
		Question qtable[] = new Question[questionsList.size()];
		return (questionsList.toArray(qtable));
	}

	@Override
	public boolean verifierrep(int idrep, int idQuest) {
		// TODO Auto-generated method stub
		// return questionsList.get(idQuest).idcorrecte == idrep;
		for (Question q : questionsList) {
			if (q.id == idQuest) {
				for (Response res : q.responsesList) {
					if (res.id == idrep) {
						// return q.responsesList[idrep].verite;
						return res.verite;
					}
				}
			}
		}

		return false;
	}

}
