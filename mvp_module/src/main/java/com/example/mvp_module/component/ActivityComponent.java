
package com.example.mvp_module.component;


import com.example.lplibrary.component.AppComponent;
import com.example.lplibrary.scope.ActivityScope;
import com.example.mvp_module.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
