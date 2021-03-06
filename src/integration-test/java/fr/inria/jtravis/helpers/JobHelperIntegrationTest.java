package fr.inria.jtravis.helpers;

import fr.inria.jtravis.AbstractTest;
import fr.inria.jtravis.IntegrationTest;
import fr.inria.jtravis.entities.Job;
import fr.inria.jtravis.entities.v2.JobV2;
import fr.inria.jtravis.entities.StateType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by urli on 22/12/2016.
 */
public class JobHelperIntegrationTest extends AbstractTest {
    @Category(IntegrationTest.class)
    @Test
    public void testFromId() {
        int id = 340663038;
        Optional<Job> jobOptional = getJTravis().job().fromId(id);

        assertTrue(jobOptional.isPresent());
        Job job = jobOptional.get();

        assertEquals(id, job.getId());
        assertEquals(StateType.FAILED, job.getState());
        assertEquals(340663037, job.getBuild().getId());
        assertEquals(2800492, job.getRepository().getId());
        assertEquals(101294919, job.getCommit().getId());
        assertEquals(83206, job.getOwner().getId());
    }

    @Category(IntegrationTest.class)
    @Test
    public void testFromIdStr() {
        String id = "340663038";
        Optional<Job> jobOptional = getJTravis().job().fromId(id);

        assertTrue(jobOptional.isPresent());
        Job job = jobOptional.get();
        assertEquals(340663038, job.getId());
        assertEquals(StateType.FAILED, job.getState());
        assertEquals(340663037, job.getBuild().getId());
        assertEquals(2800492, job.getRepository().getId());
        assertEquals(101294919, job.getCommit().getId());
        assertEquals(83206, job.getOwner().getId());
    }

    @Category(IntegrationTest.class)
    @Test
    public void testGetAllFromV2() {
        Optional<List<JobV2>> optionalJobV2s = getJTravis().job().allFromV2();

        assertTrue(optionalJobV2s.isPresent());

        List<JobV2> jobV2s = optionalJobV2s.get();

        assertEquals(250, jobV2s.size());

        JobV2 jobV2 = jobV2s.get(0);
        assertTrue(jobV2.getId() > 359389920);
        assertNotNull(jobV2.getNumber());
        assertNotNull(jobV2.getState());
        assertTrue(jobV2.getRepositoryId() > 0);
    }

    @Category(IntegrationTest.class)
    @Test
    public void testFromIdV2() {
        int id = 340663038;
        Optional<JobV2> jobOptional = getJTravis().job().fromIdV2(id);

        assertTrue(jobOptional.isPresent());
        JobV2 job = jobOptional.get();

        assertEquals(id, job.getId());
        assertEquals(StateType.FAILED, job.getState());
        assertEquals("4744.1", job.getNumber());
        assertEquals(2800492, job.getRepositoryId());
        assertEquals(340663037, job.getBuildId());
        assertEquals("java", job.getConfig().getLanguage());
    }
}
