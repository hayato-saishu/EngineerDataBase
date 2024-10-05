import React from "react";
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
import EngineerSearchForm from "../../components/EngineerSearchForm/EngineerSearchForm";

interface Engineer {
  id: number;
  name: string;
  age: number;
  language: string;
  yearsOfExperience: number;
}

interface SearchResultsProps {
  results: Engineer[];
}

const SearchResults: React.FC<SearchResultsProps> = ({ results }) => {
  return (
    <>
      <EngineerSearchForm />
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

export default SearchResults;
