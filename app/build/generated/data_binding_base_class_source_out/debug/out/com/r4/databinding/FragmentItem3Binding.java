// Generated by view binder compiler. Do not edit!
package com.r4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.r4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentItem3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView courseName;

  @NonNull
  public final TextView deadline;

  @NonNull
  public final ConstraintLayout linearLayout3;

  @NonNull
  public final TextView projectLimit;

  @NonNull
  public final Button viewBtn;

  private FragmentItem3Binding(@NonNull ConstraintLayout rootView, @NonNull TextView courseName,
      @NonNull TextView deadline, @NonNull ConstraintLayout linearLayout3,
      @NonNull TextView projectLimit, @NonNull Button viewBtn) {
    this.rootView = rootView;
    this.courseName = courseName;
    this.deadline = deadline;
    this.linearLayout3 = linearLayout3;
    this.projectLimit = projectLimit;
    this.viewBtn = viewBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentItem3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentItem3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_item3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentItem3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.course_name;
      TextView courseName = rootView.findViewById(id);
      if (courseName == null) {
        break missingId;
      }

      id = R.id.deadline;
      TextView deadline = rootView.findViewById(id);
      if (deadline == null) {
        break missingId;
      }

      ConstraintLayout linearLayout3 = (ConstraintLayout) rootView;

      id = R.id.project_limit;
      TextView projectLimit = rootView.findViewById(id);
      if (projectLimit == null) {
        break missingId;
      }

      id = R.id.view_btn;
      Button viewBtn = rootView.findViewById(id);
      if (viewBtn == null) {
        break missingId;
      }

      return new FragmentItem3Binding((ConstraintLayout) rootView, courseName, deadline,
          linearLayout3, projectLimit, viewBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}