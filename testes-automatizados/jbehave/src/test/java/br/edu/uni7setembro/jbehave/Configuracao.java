package br.edu.uni7setembro.jbehave;

import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class Configuracao {

	
    public Configuration configuration() {
    	
    	Keywords keywords = new LocalizedKeywords(new Locale("pt"));
    	
        return new MostUsefulConfiguration()
        	.useKeywords(keywords)
        	.useStoryParser(new RegexStoryParser(keywords))
            // Onde procurar pelas est�rias
        	.useStoryLoader(new LoadFromClasspath(this.getClass()))
            // Para onde fazer os reports
            .useStoryReporterBuilder(new StoryReporterBuilder()
            								.withDefaultFormats()
            								.withFormats(Format.CONSOLE, Format.HTML)); 
    }
}
