// Generated code from Butter Knife. Do not modify!
package com.packt.abuzar.extractingmodel.list;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.packt.abuzar.extractingmodel.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainAdapter_ViewBinding implements Unbinder {
  private MainAdapter target;

  @UiThread
  public MainAdapter_ViewBinding(MainAdapter target, View source) {
    this.target = target;

    target.titleView = Utils.findRequiredViewAsType(source, R.id.title, "field 'titleView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainAdapter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleView = null;
  }
}
