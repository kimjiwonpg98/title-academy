import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity('users')
export class userEntity {
  @PrimaryGeneratedColumn()
  no: number;

  @Column({ length: 30 })
  nickname: string;

  @Column()
  createAt: string;
}
