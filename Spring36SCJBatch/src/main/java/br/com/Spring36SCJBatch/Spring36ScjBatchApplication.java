package br.com.Spring36SCJBatch;

import br.com.Spring36SCJBatch.model.Aluno;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class Spring36ScjBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring36ScjBatchApplication.class, args);
	}

	@Bean
	public FlatFileItemReader<Aluno> itemReader(@Value("${file.input}") Resource resource) {

		return new FlatFileItemReaderBuilder<Aluno>()
				.delimited().delimiter(";")
				.names("nome","rm","codigoCurso")
				.resource(resource)
				.targetType(Aluno.class)
				.name("File Item Reader")
				.build();
	}

	@Bean
	public ItemProcessor<Aluno, Aluno> itemProcessor(){
		return aluno -> {
			aluno.setNome(aluno.getNome().toUpperCase());
			aluno.setRm(aluno.getRm());
			aluno.setCodigoCurso(aluno.getCodigoCurso());
			return aluno;
		};
	}

	@Bean
	public JdbcBatchItemWriter itemWriter (DataSource dataSource){
		return new JdbcBatchItemWriterBuilder()
				.beanMapped()
				.dataSource(dataSource)
				.sql("insert into tb_aluno (rm, nome,codigo_curso) values (:rm, :nome,:codigoCurso)")
				.build();
	}

	@Bean
	@Qualifier("stepchunk")
	public Step stepChunk(StepBuilderFactory stepBuilderFactory, ItemReader<Aluno> itemReader,
						  ItemProcessor<Aluno, Aluno> itemProcessor, ItemWriter<Aluno> itemWriter) {
		return stepBuilderFactory.get("step processar aluno")
				.<Aluno, Aluno>chunk(3)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, @Qualifier("stepchunk") Step step) {
		return jobBuilderFactory.get("job processor alunos")
				.start(step)
				.build();
	}

}
