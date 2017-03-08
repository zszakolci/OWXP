package com.liferay.micro.maintainance.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

public class VotesJSONSerializer {

	public static String createVotes() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("yes", 0);
		jsonObject.put("no", 0);
		jsonObject.put("not_voted", 0);

		return jsonObject.toString();
	}

	public static String updateVotes(
			String analysisData, int previousVote, int vote) 
		throws JSONException {

		JSONObject jsonObject = _jsonFactory.createJSONObject(
			analysisData);

		if (previousVote == VoteConstants.NO) {
			decreaseVote(jsonObject, "no");
		}
		else if (previousVote == VoteConstants.YES) {
			decreaseVote(jsonObject, "yes");
		}
		else if (previousVote == VoteConstants.NOT_VOTED) {
			decreaseVote(jsonObject, "not_voted");
		}

		if (vote == VoteConstants.NO) {
			increaseVote(jsonObject, "no");
		}
		else if (vote == VoteConstants.YES) {
			increaseVote(jsonObject, "yes");
		}
		else if (vote == VoteConstants.NOT_VOTED) {
			increaseVote(jsonObject, "not_voted");
		}

		return jsonObject.toString();
	}
	
	private static void increaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);
		jsonObject.put(vote, ++votes);
	}

	private static void decreaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);
		jsonObject.put(vote, -votes);
	}

	private static JSONFactory _jsonFactory;
}
