
package com.example.mvp_module.component;


import com.example.lplibrary.component.AppComponent;
import com.example.lplibrary.scope.UtilsScope;

import dagger.Component;

@UtilsScope
@Component(dependencies = AppComponent.class)
public interface UtilsComponent {


}
