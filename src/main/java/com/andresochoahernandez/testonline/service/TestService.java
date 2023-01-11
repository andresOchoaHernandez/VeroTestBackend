package com.andresochoahernandez.testonline.service;

import com.andresochoahernandez.testonline.model.domain.Test;
import com.andresochoahernandez.testonline.model.domain.TestPK;
import com.andresochoahernandez.testonline.repository.domain.TestRepository;
import com.andresochoahernandez.testonline.resolvers.inputs.TestInput;
import com.andresochoahernandez.testonline.resolvers.types.TestType;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepository test;

    public TestService(TestRepository test)
    {
        this.test = test;
    }

    public List<TestType> GQLTypeGetAllTests()
    {
        List<Test> allTests = test.findAll();
        List<TestType> response = new LinkedList<>();
        for(Test curr : allTests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    public TestType GQLTypeGetTestByDateHourAndName(String data,String hour,String nome)
    {
        try
        {
            Timestamp timestamp = Timestamp.valueOf(data + " " + hour + ":00");
            Optional<Test> result = test.findById(new TestPK(timestamp,nome));
            return result.isEmpty()?null:new TestType(result.get());
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public List<TestType> GQLTypeGetTestsByDateAndName(String data,String nome)
    {
        List<Test> tests = test.getTestByDateAndName(data,nome);

        List<TestType> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    public List<TestType> GQLTypeGetTestsByDate(String data)
    {
        List<Test> tests = test.getTestByDate(data);

        List<TestType> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    public List<TestType> GQLTypeGetTestsByName(String nome)
    {
        List<Test> tests = test.getTestByName(nome);

        List<TestType> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    public boolean createTest(TestInput input){
        try{
            Timestamp.valueOf(input.getData() + " " + input.getOra() + ":00");
            test.save(input.toJpaEntity());
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
