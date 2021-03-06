package org.eclipse.xtext.idea.wizard;

import com.google.common.collect.Iterables;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.ProjectBuilder;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBTextField;
import java.awt.GridBagConstraints;
import java.util.Set;
import java.util.function.Consumer;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.eclipse.xtext.idea.util.IdeaWidgetFactory;
import org.eclipse.xtext.idea.util.PlatformUtil;
import org.eclipse.xtext.idea.wizard.XtextModuleBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.IntellijProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WebProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@SuppressWarnings("all")
public class XtextWizardStep extends ModuleWizardStep {
  private final static Logger LOG = Logger.getInstance(XtextWizardStep.class.getName());
  
  @Extension
  private IdeaWidgetFactory _ideaWidgetFactory = new IdeaWidgetFactory();
  
  @Extension
  private PlatformUtil _platformUtil = new PlatformUtil();
  
  private JPanel mainPanel;
  
  private JTextField nameField;
  
  private JTextField extensionField;
  
  private JCheckBox idea;
  
  private JCheckBox web;
  
  private JCheckBox test;
  
  private ComboBox buildSystem;
  
  private ComboBox layout;
  
  private WizardContext context;
  
  public XtextWizardStep(final WizardContext context) {
    this.context = context;
  }
  
  @Override
  public JComponent getComponent() {
    try {
      if ((this.mainPanel == null)) {
        JPanel _createMainPanel = this.createMainPanel();
        this.mainPanel = _createMainPanel;
        this.idea.setSelected(true);
      }
      return this.mainPanel;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exception = (Exception)_t;
        XtextWizardStep.LOG.error("Initialisation failed.", exception);
        return new JPanel();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public JPanel createMainPanel() {
    final Function1<IdeaWidgetFactory.TwoColumnPanel, IdeaWidgetFactory.TwoColumnPanel> _function = (IdeaWidgetFactory.TwoColumnPanel it) -> {
      IdeaWidgetFactory.TwoColumnPanel _xblockexpression = null;
      {
        final Function1<GridBagConstraints, JComponent> _function_1 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.separator("Language");
        };
        it.row(it, _function_1);
        final Function1<GridBagConstraints, JComponent> _function_2 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.label("Name:");
        };
        final Function1<GridBagConstraints, JComponent> _function_3 = (GridBagConstraints it_1) -> {
          JTextField _xblockexpression_1 = null;
          {
            this._ideaWidgetFactory.expand(it_1, GridBagConstraints.HORIZONTAL);
            JBTextField _textField = this._ideaWidgetFactory.textField("org.xtext.example.mydsl.MyDsl");
            _xblockexpression_1 = this.nameField = _textField;
          }
          return _xblockexpression_1;
        };
        it.row(it, _function_2, _function_3);
        final Function1<GridBagConstraints, JComponent> _function_4 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.label("Extension:");
        };
        final Function1<GridBagConstraints, JComponent> _function_5 = (GridBagConstraints it_1) -> {
          JBTextField _textField = this._ideaWidgetFactory.textField("mydsl");
          return this.extensionField = _textField;
        };
        it.row(it, _function_4, _function_5);
        final Function1<GridBagConstraints, JComponent> _function_6 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.label(" ");
        };
        it.row(it, _function_6);
        final Function1<GridBagConstraints, JComponent> _function_7 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.separator("Facets");
        };
        it.row(it, _function_7);
        final Function1<GridBagConstraints, JComponent> _function_8 = (GridBagConstraints it_1) -> {
          JCheckBox _checkBox = this._ideaWidgetFactory.checkBox("Intellij Idea Plugin");
          return this.idea = _checkBox;
        };
        it.row(it, _function_8);
        final Function1<GridBagConstraints, JComponent> _function_9 = (GridBagConstraints it_1) -> {
          JCheckBox _checkBox = this._ideaWidgetFactory.checkBox("Web Integration");
          return this.web = _checkBox;
        };
        it.row(it, _function_9);
        final Function1<GridBagConstraints, JComponent> _function_10 = (GridBagConstraints it_1) -> {
          JCheckBox _checkBox = this._ideaWidgetFactory.checkBox("Testing Support");
          return this.test = _checkBox;
        };
        it.row(it, _function_10);
        final Function1<GridBagConstraints, JComponent> _function_11 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.label(" ");
        };
        it.row(it, _function_11);
        final Function1<GridBagConstraints, JComponent> _function_12 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.separator("Project Settings");
        };
        it.row(it, _function_12);
        final Function1<GridBagConstraints, JComponent> _function_13 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.label("Build System:");
        };
        final Function1<GridBagConstraints, JComponent> _function_14 = (GridBagConstraints it_1) -> {
          ComboBox _xblockexpression_1 = null;
          {
            this._ideaWidgetFactory.indentRight(it_1, 400);
            ComboBox _xifexpression = null;
            boolean _isMavenInstalled = this._platformUtil.isMavenInstalled();
            if (_isMavenInstalled) {
              _xifexpression = this._ideaWidgetFactory.comboBox(BuildSystem.GRADLE, BuildSystem.MAVEN);
            } else {
              _xifexpression = this._ideaWidgetFactory.comboBox(BuildSystem.GRADLE);
            }
            _xblockexpression_1 = this.buildSystem = _xifexpression;
          }
          return _xblockexpression_1;
        };
        it.row(it, _function_13, _function_14);
        final Function1<GridBagConstraints, JComponent> _function_15 = (GridBagConstraints it_1) -> {
          return this._ideaWidgetFactory.label("Source Layout:");
        };
        final Function1<GridBagConstraints, JComponent> _function_16 = (GridBagConstraints it_1) -> {
          ComboBox _xblockexpression_1 = null;
          {
            this._ideaWidgetFactory.indentRight(it_1, 400);
            ComboBox _comboBox = this._ideaWidgetFactory.comboBox(SourceLayout.MAVEN, SourceLayout.PLAIN);
            _xblockexpression_1 = this.layout = _comboBox;
          }
          return _xblockexpression_1;
        };
        it.row(it, _function_15, _function_16);
        final Function1<GridBagConstraints, JComponent> _function_17 = (GridBagConstraints it_1) -> {
          JLabel _xblockexpression_1 = null;
          {
            this._ideaWidgetFactory.expand(it_1, GridBagConstraints.VERTICAL);
            _xblockexpression_1 = this._ideaWidgetFactory.label("");
          }
          return _xblockexpression_1;
        };
        _xblockexpression = it.row(it, _function_17);
      }
      return _xblockexpression;
    };
    return this._ideaWidgetFactory.twoColumnPanel(_function);
  }
  
  @Override
  public void updateDataModel() {
    ProjectBuilder _projectBuilder = this.context.getProjectBuilder();
    final XtextModuleBuilder xtextBuilder = ((XtextModuleBuilder) _projectBuilder);
    final WizardConfiguration config = xtextBuilder.getWizardConfiguration();
    LanguageDescriptor _language = config.getLanguage();
    String _text = this.nameField.getText();
    _language.setName(_text);
    LanguageDescriptor _language_1 = config.getLanguage();
    String _text_1 = this.extensionField.getText();
    LanguageDescriptor.FileExtensions _fromString = LanguageDescriptor.FileExtensions.fromString(_text_1);
    _language_1.setFileExtensions(_fromString);
    RuntimeProjectDescriptor _runtimeProject = config.getRuntimeProject();
    _runtimeProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = config.getIdeProject();
    _ideProject.setEnabled((this.idea.isSelected() || this.web.isSelected()));
    IntellijProjectDescriptor _intellijProject = config.getIntellijProject();
    boolean _isSelected = this.idea.isSelected();
    _intellijProject.setEnabled(_isSelected);
    WebProjectDescriptor _webProject = config.getWebProject();
    boolean _isSelected_1 = this.web.isSelected();
    _webProject.setEnabled(_isSelected_1);
    Set<ProjectDescriptor> _enabledProjects = config.getEnabledProjects();
    Iterable<TestedProjectDescriptor> _filter = Iterables.<TestedProjectDescriptor>filter(_enabledProjects, TestedProjectDescriptor.class);
    final Consumer<TestedProjectDescriptor> _function = (TestedProjectDescriptor it) -> {
      TestProjectDescriptor _testProject = it.getTestProject();
      boolean _isSelected_2 = this.test.isSelected();
      _testProject.setEnabled(_isSelected_2);
    };
    _filter.forEach(_function);
    Object _selectedItem = this.buildSystem.getSelectedItem();
    config.setPreferredBuildSystem(((BuildSystem) _selectedItem));
    Object _selectedItem_1 = this.layout.getSelectedItem();
    config.setSourceLayout(((SourceLayout) _selectedItem_1));
    config.setProjectLayout(ProjectLayout.HIERARCHICAL);
  }
  
  @Override
  public boolean validate() throws ConfigurationException {
    final boolean superCall = super.validate();
    return superCall;
  }
}
