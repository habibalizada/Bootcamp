package com.trilogyed.commentqueueconsumer;

//import com.trilogyed.notequeue.consumer.util.feign.NoteClient;
//import com.trilogyed.notequeue.consumer.util.messages.Note;
import com.trilogyed.commentqueueconsumer.util.feign.CommentClient;
import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentClient client;

    public MessageListener(CommentClient client) {
        this.client = client;
    }

    @RabbitListener(queues =  CommentQueueConsumerApplication.QUEUE_NAME)
    private void receiveAddMessage(Comment msg){

        if (msg.getCommentId() == 0){
            Comment comment = client.createComment(msg);
            System.out.println("Created: " + comment.toString());
        }else {
            Comment comment = msg;
            client.updateComment(msg, msg.getCommentId());
            System.out.println("Updated: " + comment.toString());
        }
    }
}
