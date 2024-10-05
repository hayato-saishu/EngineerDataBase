import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Typography } from '@mui/material';
import axios from 'axios';

interface Engineer {
    id: number;
    name: string;
    age: number;
    address: string;
    phoneNumber: string;
}

const EngineerDetail: React.FC = () => {
    const { id } = useParams<{ id: string }>();
    const [engineer, setEngineer] = useState<Engineer | null>(null);

    useEffect(() => {
        // API呼び出しロジック
        axios.get('http://localhost:8080/engineer/detail/{id}', {
            headers: {
                "Content-Type": 'application/json'
            },
            params: {
                id: id
            }
        })
        .then(response => {
            const engineer = response.data;
            setEngineer(engineer);
        })
    }, [id]);

    if (!engineer) {
        return <div>Loading...</div>;
    }

    return (
        <Container>
            <Typography variant="h4">{engineer.name}</Typography>
            <Typography variant="body1">年齢: {engineer.age}</Typography>
            <Typography variant="body1">住所: {engineer.address}</Typography>
            <Typography variant="body1">電話番号: {engineer.phoneNumber}</Typography>
        </Container>
    );
};

export default EngineerDetail;
