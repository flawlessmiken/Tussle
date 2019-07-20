package com.flawless.tussle.utils;

import android.net.Uri;

import com.flawless.tussle.R;
import com.flawless.tussle.model.User;


public class DummyUsers {

    public User[] USERS = {
            James, Carol,James,Elizabet,Donald,Charles,Jessica,Joseph,Matthew,Michael,Nancy
    };



    public static final User James = new User(Uri.parse("android.resource://com.flawless.tussle/" + R.drawable.zjames).toString(),
            "James","male","expert","1,200","200"
          );


    public static final User Elizabet = new User(Uri.parse
            ("android.resource://com.flawless.tussle/"+ R.drawable.zelizabeth).toString(),
            "Elizabeth","female","beginner","200","10"
    );
    public static final User Donald = new User(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.zdonald).toString(),
            "Donald","male","Professional","2,050","250"
    );

    public static final User Carol = new User(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.zcarol).toString(),
            "Carol","female","enthusiast","550","70"
    );

    public static final User Charles = new User(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.zcharles).toString(),
            "Charles","male","enthusiast","550","70"
    );


    public static final User Jessica = new User(Uri.parse("android.resource://com.flawless.tussle/" + R.drawable.zjessica).toString(),
            "Jessica","female","enthusiast","600","75"
    );


    public static final User Joseph = new User(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.zjoseph).toString(),
            "Joseph","female","beginner","200","30"
    );
    public static final User Matthew = new User(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.zmattew).toString(),
            "Matthew","male","Professional","2,050","250"
    );

    public static final User Michael = new User(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.zmichael).toString(),
            "Charles","male","Ultimate","3,000","330"
    );

    public static final User Nancy = new User(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.znancy).toString(),
            "Nancy","female","beginner","200","30"
    );


}



















