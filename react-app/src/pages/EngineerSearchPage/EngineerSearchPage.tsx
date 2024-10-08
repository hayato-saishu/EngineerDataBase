import React, { useState } from "react";
import { Link } from "react-router-dom";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from "@mui/material";
import SearchForm from "../../components/EngineerSearchForm/EngineerSearchForm";

interface Engineer {
  id: number;
  name: string;
  age: number;
  language: string;
  yearsOfExperience: number;
}

const EngineerSearchPage: React.FC = () => {
  const [results, setResults] = useState<Engineer[]>([]);

  return (
    <>
      <SearchForm setResults={setResults} /> {/* setResultsプロップを渡す */}
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>名前</TableCell>
              <TableCell>年齢</TableCell>
              <TableCell>言語</TableCell>
              <TableCell>経験年数</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {results.map((engineer) => (
              <TableRow key={engineer.id}>
                <TableCell>
                  <Link to={`/engineer/Detail/${engineer.id}`}>
                    {engineer.name}
                  </Link>
                </TableCell>
                <TableCell>{engineer.age}</TableCell>
                <TableCell>{engineer.language}</TableCell>
                <TableCell>{engineer.yearsOfExperience}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default EngineerSearchPage;
