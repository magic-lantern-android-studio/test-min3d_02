package com.wizzerworks.min3d;

import com.wizzer.mle.min3d.core.Object3dContainer;
import com.wizzer.mle.min3d.core.RendererActivity;
import com.wizzer.mle.min3d.parser.IParser;
import com.wizzer.mle.min3d.parser.Parser;
import com.wizzer.mle.min3d.vos.Light;

/**
 * Created by msm on 9/27/16.
 */
public class TestMin3dActivity extends RendererActivity
{
    private Object3dContainer objModel;

    @Override
    public void initScene() {

        scene.lights().add(new Light());

        String name = this.getPackageName();

        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.wizzerworks.min3d:raw/camaro_obj", true);
        parser.parse();

        objModel = parser.getParsedObject();
        objModel.scale().x = objModel.scale().y = objModel.scale().z = .7f;
        scene.addChild(objModel);
    }

    @Override
    public void updateScene() {
        objModel.rotation().x++;
        objModel.rotation().z++;
    }
}
