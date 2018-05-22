
package com.example.mvp_module.component;


import com.example.lplibrary.component.AppComponent;
import com.example.lplibrary.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent {


}
