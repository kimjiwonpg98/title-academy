import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
      envFilePath: `.${process.env.NODE_ENV}.env`,
    }),
    TypeOrmModule.forRoot({
      host: process.env.DB_HOST,
      port: Number(process.env.DB_PORT) || 3306,
      database: process.env.DB,
      password: process.env.DB_PASSWORD,
      username: process.env.DB_USER,
      entities: [`${__dirname}/**/*.entity.{js,ts}`],
    }),
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
