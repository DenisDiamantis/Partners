// Generated by view binder compiler. Do not edit!
package com.r4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.r4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button CreateTeamButton;

  @NonNull
  public final EditText EnterCourse;

  @NonNull
  public final Button MessageButton;

  @NonNull
  public final Button MyTeamsButton;

  @NonNull
  public final Button SearchButton;

  @NonNull
  public final Button editInfo;

  @NonNull
  public final Guideline guideline3;

  private ActivityMenuBinding(@NonNull ConstraintLayout rootView, @NonNull Button CreateTeamButton,
      @NonNull EditText EnterCourse, @NonNull Button MessageButton, @NonNull Button MyTeamsButton,
      @NonNull Button SearchButton, @NonNull Button editInfo, @NonNull Guideline guideline3) {
    this.rootView = rootView;
    this.CreateTeamButton = CreateTeamButton;
    this.EnterCourse = EnterCourse;
    this.MessageButton = MessageButton;
    this.MyTeamsButton = MyTeamsButton;
    this.SearchButton = SearchButton;
    this.editInfo = editInfo;
    this.guideline3 = guideline3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Create_Team_Button;
      Button CreateTeamButton = rootView.findViewById(id);
      if (CreateTeamButton == null) {
        break missingId;
      }

      id = R.id.Enter_Course;
      EditText EnterCourse = rootView.findViewById(id);
      if (EnterCourse == null) {
        break missingId;
      }

      id = R.id.Message_Button;
      Button MessageButton = rootView.findViewById(id);
      if (MessageButton == null) {
        break missingId;
      }

      id = R.id.My_Teams_Button;
      Button MyTeamsButton = rootView.findViewById(id);
      if (MyTeamsButton == null) {
        break missingId;
      }

      id = R.id.Search_Button;
      Button SearchButton = rootView.findViewById(id);
      if (SearchButton == null) {
        break missingId;
      }

      id = R.id.editInfo;
      Button editInfo = rootView.findViewById(id);
      if (editInfo == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = rootView.findViewById(id);
      if (guideline3 == null) {
        break missingId;
      }

      return new ActivityMenuBinding((ConstraintLayout) rootView, CreateTeamButton, EnterCourse,
          MessageButton, MyTeamsButton, SearchButton, editInfo, guideline3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}