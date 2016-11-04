package chrislo27.rhre;

import chrislo27.rhre.init.DefAssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import ionium.registry.AssetRegistry;
import ionium.registry.ScreenRegistry;
import ionium.util.DebugSetting;
import ionium.util.Logger;

public class Main extends ionium.templates.Main {

	public BitmapFont biggerFont;
	public BitmapFont biggerFontBordered;
	public BitmapFont font;
	public BitmapFont fontBordered;

	public Main(Logger l) {
		super(l);
	}

	@Override
	public Screen getScreenToSwitchToAfterLoadingAssets() {
		return ScreenRegistry.get("mainMenu");
	}

	@Override
	public Screen getAssetLoadingScreenToUse() {
		return super.getAssetLoadingScreenToUse();
	}

	@Override
	public void create() {
		Main.version = "v2.0.0-alpha";

		super.create();

		Gdx.graphics.setTitle(getTitle());

		AssetRegistry.instance().addAssetLoader(new DefAssetLoader());

		DebugSetting.showFPS = false;

		new Transformation();
	}

	@Override
	public void prepareStates() {
		super.prepareStates();

		ScreenRegistry reg = ScreenRegistry.instance();

	}

	@Override
	protected void preRender() {
		super.preRender();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	protected void postRender() {
		batch.begin();

		fontBordered.setColor(1, 1, 1, 1);
		fontBordered.draw(batch, "ALL VISUALS SUBJECT TO CHANGE", 8, Gdx.graphics.getHeight() - 8);
		fontBordered.draw(batch, "THIS IS AN EARLY-STAGE DEV BUILD", 8,
				Gdx.graphics.getHeight() - 8 - font.getLineHeight());
		fontBordered.setColor(1, 1, 1, 1);

		batch.end();

		super.postRender();
	}

	@Override
	protected Array<String> getDebugStrings() {
		return super.getDebugStrings();
	}

	@Override
	public void tickUpdate() {
		super.tickUpdate();
	}

	@Override
	public void inputUpdate() {
		super.inputUpdate();
	}

	@Override
	public void loadFont() {
		super.loadFont();

		FreeTypeFontGenerator ttfGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PTSans.ttf"));

		FreeTypeFontGenerator.FreeTypeFontParameter ttfParam = new FreeTypeFontGenerator.FreeTypeFontParameter();
		ttfParam.magFilter = Texture.TextureFilter.Nearest;
		ttfParam.minFilter = Texture.TextureFilter.Linear;
		ttfParam.genMipMaps = true;
		ttfParam.size = 24;
		//ttfParam.characters += SpecialCharactersList.getJapaneseKana();

		font = ttfGenerator.generateFont(ttfParam);
		font.getData().markupEnabled = true;
		font.setFixedWidthGlyphs("0123456789");

		ttfParam.size *= 4;
		biggerFont = ttfGenerator.generateFont(ttfParam);
		biggerFont.getData().markupEnabled = true;
		biggerFont.setFixedWidthGlyphs("0123456789");

		ttfParam.borderWidth = 1.5f;
		ttfParam.size /= 4;

		fontBordered = ttfGenerator.generateFont(ttfParam);
		fontBordered.getData().markupEnabled = true;
		fontBordered.setFixedWidthGlyphs("0123456789");

		ttfParam.size *= 4;
		ttfParam.borderWidth *= 4;
		biggerFontBordered = ttfGenerator.generateFont(ttfParam);
		biggerFontBordered.getData().markupEnabled = true;
		biggerFontBordered.setFixedWidthGlyphs("0123456789");

		ttfGenerator.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void dispose() {
		super.dispose();

		biggerFont.dispose();
		biggerFontBordered.dispose();
		font.dispose();
		fontBordered.dispose();
	}
}