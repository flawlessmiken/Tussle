package com.flawless.tussle;

import com.flawless.tussle.adapters.ReviewAnswerAdapter;
import com.flawless.tussle.model.QuizModel;
import com.flawless.tussle.model.ReviewModel;
import com.flawless.tussle.model.User;


/**
 * Created by User on 1/24/2018.
 */

public interface IMainActivity {

    void inflateListSelectedItems(QuizModel model);

    void inflateReviwBoard(ReviewModel reviewModel);

    void inflateChallengeRoom(User user);
}

